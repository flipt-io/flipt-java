package com.flipt.api.client.auth;

import com.fern.java.jersey.contracts.OptionalAwareContract;
import com.flipt.api.client.auth.exceptions.VerifyServiceAccountException;
import com.flipt.api.client.auth.types.AuthenticationToken;
import com.flipt.api.client.auth.types.KubernetesVerifyServiceAccount;
import com.flipt.api.core.ObjectMappers;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;
import java.lang.String;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/auth/v1/method/kubernetes")
interface AuthenticationMethodKubernetes {
  @POST
  @Path("/serviceaccount")
  AuthenticationToken verifyServiceAccount(KubernetesVerifyServiceAccount body) throws
      VerifyServiceAccountException;

  static AuthenticationMethodKubernetes getClient(String url) {
    return Feign.builder()
        .contract(new OptionalAwareContract(new JAXRSContract()))
        .decoder(new JacksonDecoder(ObjectMappers.JSON_MAPPER))
        .encoder(new JacksonEncoder(ObjectMappers.JSON_MAPPER))
        .errorDecoder(new AuthenticationMethodKubernetesErrorDecoder()).target(AuthenticationMethodKubernetes.class, url);
  }
}
