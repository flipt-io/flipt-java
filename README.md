# Flipt Java Library

![Maven Central](https://img.shields.io/maven-central/v/io.flipt/flipt-java)

## Documentation

API documentation is available at <https://www.flipt.io/docs/reference/overview>.

## Install

### Gradle

Add to your root build.gradle at the end of repositories:

Add the dependency:

```groovy
dependencies {
    implementation 'io.flipt-io:flipt-java:0.x.x'
}
```

## Usage

Check out the [sample app](sample-app/src/main/java/sample/App.java) which consumes this SDK!

```java
import com.flipt.api.FliptApiClient;
import com.flipt.api.client.flags.endpoints.Get;
import com.flipt.api.client.flags.exceptions.GetException;
import com.flipt.api.client.flags.types.Flag;
import com.flipt.api.core.BearerAuth;
import com.flipt.api.core.Environment;

public class App {
  public static void main(String[] args) {
    String token = System.getenv("FLIPT_API_TOKEN");

    BearerAuth auth = BearerAuth.of(token);

    FliptApiClient fliptApiClient = new FliptApiClient(Environment.custom("http://localhost:8080"), auth);

    try {
        Flag flag = fliptApiClient.flags().get(Get.Request.builder()
                .key("flag_abc123")
                .build());
        System.out.println("Successfully fetched flag with id" + flag.getKey());
    } catch (GetException e) {
        System.out.println("Encountered error while getting flag" + e.getMessage());
    }
  }
}
```

## Beta status

This SDK is in beta, and there may be breaking changes between versions without a major version update. Therefore, we recommend pinning the package version to a specific version in your build.gradle file. This way, you can install the same version each time without breaking changes unless you are intentionally looking for the latest version.

## Contributing

While we value open-source contributions to this SDK, this library is generated programmatically. Additions made directly to this library would have to be moved over to our generation code, otherwise they would be overwritten upon the next generated release. Feel free to open a PR as a proof of concept, but know that we will not be able to merge it as-is. We suggest [opening an issue](https://github.com/flipt-io/flipt-java/issues) first to discuss with us!

On the other hand, contributions to the README are always very welcome!
