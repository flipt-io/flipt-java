package com.flipt.api.client.auth;

import com.fern.java.jersey.contracts.OptionalAwareContract;
import com.flipt.api.client.auth.exceptions.DeleteTokenException;
import com.flipt.api.client.auth.exceptions.ExpireSelfException;
import com.flipt.api.client.auth.exceptions.GetSelfException;
import com.flipt.api.client.auth.exceptions.GetTokenException;
import com.flipt.api.client.auth.exceptions.ListTokensException;
import com.flipt.api.client.auth.types.AuthenticationExpireSelfRequest;
import com.flipt.api.client.auth.types.AuthenticationList;
import com.flipt.api.core.BearerAuth;
import com.flipt.api.core.ObjectMappers;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;
import java.lang.String;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/auth/v1")
interface Authentication {
  @GET
  @Path("/tokens")
  AuthenticationList listTokens(@HeaderParam("Authorization") BearerAuth auth) throws
      ListTokensException;

  @GET
  @Path("/tokens/{id}")
  com.flipt.api.client.auth.types.Authentication getToken(
      @HeaderParam("Authorization") BearerAuth auth, @PathParam("id") String id) throws
      GetTokenException;

  @DELETE
  @Path("/tokens/{id}")
  void deleteToken(@HeaderParam("Authorization") BearerAuth auth, @PathParam("id") String id) throws
      DeleteTokenException;

  @GET
  @Path("/self")
  com.flipt.api.client.auth.types.Authentication getSelf(
      @HeaderParam("Authorization") BearerAuth auth) throws GetSelfException;

  @PUT
  @Path("/self/expire")
  void expireSelf(@HeaderParam("Authorization") BearerAuth auth,
      AuthenticationExpireSelfRequest body) throws ExpireSelfException;

  static Authentication getClient(String url) {
    return Feign.builder()
        .contract(new OptionalAwareContract(new JAXRSContract()))
        .decoder(new JacksonDecoder(ObjectMappers.JSON_MAPPER))
        .encoder(new JacksonEncoder(ObjectMappers.JSON_MAPPER))
        .errorDecoder(new AuthenticationErrorDecoder()).target(Authentication.class, url);
  }
}
