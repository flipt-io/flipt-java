package com.flipt.api.client.variants;

import com.fern.java.jersey.contracts.OptionalAwareContract;
import com.flipt.api.client.variants.exceptions.CreateException;
import com.flipt.api.client.variants.exceptions.DeleteException;
import com.flipt.api.client.variants.exceptions.UpdateException;
import com.flipt.api.client.variants.types.Variant;
import com.flipt.api.client.variants.types.VariantCreateRequest;
import com.flipt.api.client.variants.types.VariantUpdateRequest;
import com.flipt.api.core.BasicAuth;
import com.flipt.api.core.ObjectMappers;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;
import java.lang.String;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/api/v1/flags/{flagKey}/variants")
interface VariantsService {
  @POST
  @Path("/")
  Variant create(@HeaderParam("Authorization") BasicAuth auth, VariantCreateRequest body) throws
      CreateException;

  @DELETE
  @Path("/{id}")
  void delete(@HeaderParam("Authorization") BasicAuth auth, @PathParam("id") String id) throws
      DeleteException;

  @PUT
  @Path("/{id}")
  Variant update(@HeaderParam("Authorization") BasicAuth auth, @PathParam("id") String id,
      VariantUpdateRequest body) throws UpdateException;

  static VariantsService getClient(String url) {
    return Feign.builder()
        .contract(new OptionalAwareContract(new JAXRSContract()))
        .decoder(new JacksonDecoder(ObjectMappers.JSON_MAPPER))
        .encoder(new JacksonEncoder(ObjectMappers.JSON_MAPPER))
        .errorDecoder(new VariantsServiceErrorDecoder()).target(VariantsService.class, url);
  }
}