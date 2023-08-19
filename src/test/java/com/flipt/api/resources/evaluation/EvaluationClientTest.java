package com.flipt.api.resources.evaluation;

import com.flipt.api.FliptApiClient;
import com.flipt.api.FliptContainer;
import com.flipt.api.resources.evaluation.types.EvaluationRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.nio.file.Paths;
import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
class EvaluationClientTest {

    @Container
    private static final FliptContainer container = new FliptContainer();

    private static FliptApiClient client;

    @BeforeAll
    static void setup(){
        client = FliptApiClient.builder()
                .url(container.getEndpoint())
                .build();
    }

    @AfterEach
    void clear() throws Exception {
        container.dropData();
    }

    @Test
    void canEvaluateFlag_boolean() throws Exception {
        final var conf = Paths.get("src/test/resources/EvaluationClientTest_boolean.yaml");
        container.importConfiguration(conf);

        var evaluationResponse = client.evaluation().boolean_(forFlagKey("test_flag", Collections.emptyMap()));

        assertNotNull(evaluationResponse);
        assertTrue(evaluationResponse.getEnabled());
    }

    @Test
    void canEvaluateFlag_variant() throws Exception {
        final var conf = Paths.get("src/test/resources/EvaluationClientTest_variant.yaml");
        container.importConfiguration(conf);

        var evaluationResponse = client.evaluation().variant(forFlagKey("test_flag", Collections.singletonMap("group", "red")));

        assertNotNull(evaluationResponse);
        assertEquals("red", evaluationResponse.getVariantKey());
    }

    private EvaluationRequest forFlagKey(String flagKey, Map<String, String> context){
        return EvaluationRequest.builder()
                .namespaceKey("default")
                .flagKey(flagKey)
                .entityId("")
                .context(context)
                .build();
    }
}