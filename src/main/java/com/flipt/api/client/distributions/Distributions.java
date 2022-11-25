package com.flipt.api.client.distributions;

import com.fern.java.jersey.contracts.OptionalAwareContract;
import com.flipt.api.client.distributions.exceptions.CreateException;
import com.flipt.api.client.distributions.exceptions.DeleteException;
import com.flipt.api.client.distributions.exceptions.UpdateException;
import com.flipt.api.client.distributions.types.Distribution;
import com.flipt.api.client.distributions.types.DistributionCreateRequest;
import com.flipt.api.client.distributions.types.DistributionUpdateRequest;
import com.flipt.api.core.BearerAuth;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/api/v1/flags/{flagKey}/rules/{ruleId}/distributions")
interface Distributions {
  @POST
  @Path("")
  Distribution create(@HeaderParam("Authorization") BearerAuth auth, DistributionCreateRequest body)
      throws CreateException;

  @DELETE
  @Path("/{id}")
  void delete(@HeaderParam("Authorization") BearerAuth auth, @PathParam("id") String id,
      @QueryParam("variantId") String variantId) throws DeleteException;

  @PUT
  @Path("/{id}")
  Distribution update(@HeaderParam("Authorization") BearerAuth auth, @PathParam("id") String id,
      DistributionUpdateRequest body) throws UpdateException;

  static Distributions getClient(String url) {
    return Feign.builder()
        .contract(new OptionalAwareContract(new JAXRSContract()))
        .decoder(new JacksonDecoder(ObjectMappers.JSON_MAPPER))
        .encoder(new JacksonEncoder(ObjectMappers.JSON_MAPPER))
        .errorDecoder(new DistributionsErrorDecoder()).target(Distributions.class, url);
  }
}
