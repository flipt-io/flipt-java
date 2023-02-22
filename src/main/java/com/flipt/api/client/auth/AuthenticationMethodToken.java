package com.flipt.api.client.auth;

import com.fern.java.jersey.contracts.OptionalAwareContract;
import com.flipt.api.client.auth.exceptions.CreateTokenException;
import com.flipt.api.client.auth.types.AuthenticationToken;
import com.flipt.api.client.auth.types.AuthenticationTokenCreateRequest;
import com.flipt.api.core.BearerAuth;
import com.flipt.api.core.ObjectMappers;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;
import java.lang.String;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/auth/v1/method/token")
interface AuthenticationMethodToken {
  @POST
  @Path("/")
  AuthenticationToken createToken(@HeaderParam("Authorization") BearerAuth auth,
      AuthenticationTokenCreateRequest body) throws CreateTokenException;

  static AuthenticationMethodToken getClient(String url) {
    return Feign.builder()
        .contract(new OptionalAwareContract(new JAXRSContract()))
        .decoder(new JacksonDecoder(ObjectMappers.JSON_MAPPER))
        .encoder(new JacksonEncoder(ObjectMappers.JSON_MAPPER))
        .errorDecoder(new AuthenticationMethodTokenErrorDecoder()).target(AuthenticationMethodToken.class, url);
  }
}
