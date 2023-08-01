package sample;

import com.flipt.api.FliptApiClient;
import com.flipt.api.core.Defaults;
import com.flipt.api.resources.evaluation.types.EvaluationRequest;
import com.flipt.api.resources.evaluation.types.VariantEvaluationResponse;
import com.flipt.api.resources.flags.types.Flag;

public class App {
  private static final String FLIPT_URL = "http://localhost:8080";

  public static void main(String[] args) {
    String token = System.getenv("FLIPT_API_TOKEN");

    FliptApiClient fliptApiClient = FliptApiClient.builder().token(token).url(FLIPT_URL).build();

    try {
      Flag flag = fliptApiClient.flags().get(Defaults.NAMESPACE, "flag_abc123");
      System.out.println("Successfully fetched flag with id" + flag.getKey());
    } catch (Exception e) {
      System.out.println("Encountered error while getting flag" + e.getMessage());
    }

    try {
      EvaluationRequest req = EvaluationRequest.builder().namespaceKey(Defaults.NAMESPACE).flagKey("flag_abc123")
          .entityId("user_123").build();

      VariantEvaluationResponse resp = fliptApiClient.evaluation().variant(req);
      System.out.println("Successfully evaluated flag with variant" + resp.getVariantKey());
    } catch (Exception e) {
      System.out.println("Encountered error while evaluating flag" + e.getMessage());
    }
  }
}