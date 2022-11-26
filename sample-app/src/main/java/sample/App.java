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