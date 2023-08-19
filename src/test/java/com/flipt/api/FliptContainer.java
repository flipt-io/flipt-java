package com.flipt.api;

import org.testcontainers.containers.GenericContainer;
import org.testcontainers.images.builder.Transferable;
import org.testcontainers.utility.DockerImageName;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FliptContainer extends GenericContainer<FliptContainer> {

    private static final DockerImageName IMAGE_NAME = DockerImageName.parse("flipt/flipt").withTag("latest");
    private static final String DROP_TARGET_PATH = "/tmp/drop.yaml";
    private static final int PORT = 8080;

    public FliptContainer() {
        super(IMAGE_NAME);
        addExposedPort(PORT);
    }

    public void importConfiguration(Path configuration) throws Exception {
        var targetPath = "/tmp/%s".formatted(configuration.getFileName());

        copyFileToContainer(Transferable.of(Files.readAllBytes(configuration)), targetPath);
        this.execInContainer("./flipt", "import", targetPath);
    }

    public void dropData() throws Exception {
        var dropConfig = Paths.get("src/test/resources/drop.yaml");

        copyFileToContainer(Transferable.of(Files.readAllBytes(dropConfig)), DROP_TARGET_PATH);
        this.execInContainer("./flipt", "import", "--drop", DROP_TARGET_PATH);
    }

    public String getEndpoint() {
        return String.format("http://%s:%d", getHost(), getMappedPort(PORT));
    }
}
