package com.flipt.api.client.segments;

import com.fern.java.jersey.contracts.OptionalAwareContract;
import com.flipt.api.client.segments.exceptions.CreateException;
import com.flipt.api.client.segments.exceptions.DeleteException;
import com.flipt.api.client.segments.exceptions.GetException;
import com.flipt.api.client.segments.exceptions.ListException;
import com.flipt.api.client.segments.exceptions.UpdateException;
import com.flipt.api.client.segments.types.Segment;
import com.flipt.api.client.segments.types.SegmentCreateRequest;
import com.flipt.api.client.segments.types.SegmentList;
import com.flipt.api.client.segments.types.SegmentUpdateRequest;
import com.flipt.api.core.BearerAuth;
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
@Path("/api/v1/segments")
interface Segments {
  @GET
  @Path("")
  SegmentList list(@HeaderParam("Authorization") BearerAuth auth,
      @QueryParam("limit") Optional<Integer> limit, @QueryParam("offset") Optional<Integer> offset,
      @QueryParam("pageToken") Optional<String> pageToken) throws ListException;

  @POST
  @Path("")
  Segment create(@HeaderParam("Authorization") BearerAuth auth, SegmentCreateRequest body) throws
      CreateException;

  @GET
  @Path("/{key}")
  Segment get(@HeaderParam("Authorization") BearerAuth auth, @PathParam("key") String key) throws
      GetException;

  @DELETE
  @Path("/{key}")
  void delete(@HeaderParam("Authorization") BearerAuth auth, @PathParam("key") String key) throws
      DeleteException;

  @PUT
  @Path("/{key}")
  Segment update(@HeaderParam("Authorization") BearerAuth auth, @PathParam("key") String key,
      SegmentUpdateRequest body) throws UpdateException;

  static Segments getClient(String url) {
    return Feign.builder()
        .contract(new OptionalAwareContract(new JAXRSContract()))
        .decoder(new JacksonDecoder(ObjectMappers.JSON_MAPPER))
        .encoder(new JacksonEncoder(ObjectMappers.JSON_MAPPER))
        .errorDecoder(new SegmentsErrorDecoder()).target(Segments.class, url);
  }
}
