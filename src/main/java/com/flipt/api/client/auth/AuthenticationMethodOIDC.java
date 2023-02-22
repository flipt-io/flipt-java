package com.flipt.api.client.auth;

import com.fern.java.jersey.contracts.OptionalAwareContract;
import com.flipt.api.client.auth.exceptions.AuthorizeUrlException;
import com.flipt.api.client.auth.exceptions.CallbackException;
import com.flipt.api.client.auth.types.OidcAuthorizeUrlResponse;
import com.flipt.api.client.auth.types.OidcCallbackResponse;
import com.flipt.api.core.ObjectMappers;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;
import java.lang.String;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/auth/v1/method/oidc")
interface AuthenticationMethodOIDC {
  @GET
  @Path("/{provider}/authorize")
  OidcAuthorizeUrlResponse authorizeUrl(@PathParam("provider") String provider,
      @QueryParam("state") String state) throws AuthorizeUrlException;

  @GET
  @Path("/{provider}/callback")
  OidcCallbackResponse callback(@PathParam("provider") String provider,
      @QueryParam("code") String code, @QueryParam("state") String state) throws CallbackException;

  static AuthenticationMethodOIDC getClient(String url) {
    return Feign.builder()
        .contract(new OptionalAwareContract(new JAXRSContract()))
        .decoder(new JacksonDecoder(ObjectMappers.JSON_MAPPER))
        .encoder(new JacksonEncoder(ObjectMappers.JSON_MAPPER))
        .errorDecoder(new AuthenticationMethodOIDCErrorDecoder()).target(AuthenticationMethodOIDC.class, url);
  }
}
