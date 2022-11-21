package com.flipt.api.client.flags;

import com.fern.java.jersey.contracts.OptionalAwareContract;
import com.flipt.api.client.flags.exceptions.CreateException;
import com.flipt.api.client.flags.exceptions.DeleteException;
import com.flipt.api.client.flags.exceptions.GetException;
import com.flipt.api.client.flags.exceptions.ListException;
import com.flipt.api.client.flags.exceptions.UpdateException;
import com.flipt.api.client.flags.types.Flag;
import com.flipt.api.client.flags.types.FlagCreateRequest;
import com.flipt.api.client.flags.types.FlagList;
import com.flipt.api.client.flags.types.FlagUpdateRequest;
import com.flipt.api.core.BasicAuth;
import com.flipt.api.core.ObjectMappers;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;
import java.lang.Integer;
import java.lang.String;
import java.util.Optional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/api/v1/flags")
interface Flags {
  @GET
  @Path("/")
  FlagList list(@HeaderParam("Authorization") BasicAuth auth,
      @QueryParam("limit") Optional<Integer> limit, @QueryParam("offset") Optional<Integer> offset,
      @QueryParam("pageToken") Optional<String> pageToken) throws ListException;

  @POST
  @Path("/")
  Flag create(@HeaderParam("Authorization") BasicAuth auth, FlagCreateRequest body) throws
      CreateException;

  @GET
  @Path("/{key}")
  Flag get(@HeaderParam("Authorization") BasicAuth auth, @PathParam("key") String key) throws
      GetException;

  @DELETE
  @Path("/{key}")
  void delete(@HeaderParam("Authorization") BasicAuth auth, @PathParam("key") String key) throws
      DeleteException;

  @PUT
  @Path("/{key}")
  Flag update(@HeaderParam("Authorization") BasicAuth auth, @PathParam("key") String key,
      FlagUpdateRequest body) throws UpdateException;

  static Flags getClient(String url) {
    return Feign.builder()
        .contract(new OptionalAwareContract(new JAXRSContract()))
        .decoder(new JacksonDecoder(ObjectMappers.JSON_MAPPER))
        .encoder(new JacksonEncoder(ObjectMappers.JSON_MAPPER))
        .errorDecoder(new FlagsErrorDecoder()).target(Flags.class, url);
  }
}
