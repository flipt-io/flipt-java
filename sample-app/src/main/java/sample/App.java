package sample;

import com.flipt.api.FliptApiClient;

import com.flipt.api.resources.flags.types.Flag;

public class App {
  public static void main(String[] args) {
    String token = System.getenv("FLIPT_API_TOKEN");

    FliptApiClient fliptApiClient = FliptApiClient.builder().token(token).url("http://localhost:8080").build();

    try {
      Flag flag = fliptApiClient.flags().get("flag_abc123");
      System.out.println("Successfully fetched flag with id" + flag.getKey());
    } catch (Exception e) {
      System.out.println("Encountered error while getting flag" + e.getMessage());
    }
  }
}