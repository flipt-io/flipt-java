# Flipt Java Library

[![Maven Central](https://img.shields.io/maven-central/v/io.github.fern-api/flipt)](https://central.sonatype.dev/artifact/io.github.fern-api/flipt/0.1.0/versions)
![Sonatype Nexus (Releases)](https://img.shields.io/nexus/r/io.github.fern-api/flipt?server=https%3A%2F%2Fs01.oss.sonatype.org)

## Documentation

API documentation is available at <https://www.flipt.io/docs/reference/flags/list-flags>.

## Usage

Check out the [sample app](.sample-app/app.java) which consumes this SDK!

```java
import com.flipt.api.FliptApiClient;
import com.flipt.api.client.flags.endpoints.Get;
import com.flipt.api.client.flags.exceptions.GetException;
import com.flipt.api.client.flags.types.FliptFlag;
import com.flipt.api.core.BearerAuth;

String token = System.getenv("FLIPT_API_TOKEN");

BearerAuth auth = BearerAuth.of(token);

FliptApiClient fliptApiClient = new FliptApiClient("http://localhost:8080", auth);

try {
    FliptFlag fliptFlag = fliptApiClient.flags().get(Get.Request.builder()
            .key("flag_abc123")
            .build());
    System.out.println("Successfully fetched flag with id" + fliptFlag.getKey());
} catch (GetException e) {
    System.out.println("Encountered error while getting flag" + e.getMessage());
}
```

## Beta status

This SDK is in beta, and there may be breaking changes between versions without a major version update. Therefore, we recommend pinning the package version to a specific version in your build.gradle file. This way, you can install the same version each time without breaking changes unless you are intentionally looking for the latest version.

## Contributing

While we value open-source contributions to this SDK, this library is generated programmatically. Additions made directly to this library would have to be moved over to our generation code, otherwise they would be overwritten upon the next generated release. Feel free to open a PR as a proof of concept, but know that we will not be able to merge it as-is. We suggest [opening an issue](https://github.com/fern-flipt/flipt-java/issues) first to discuss with us!

On the other hand, contributions to the README are always very welcome!
