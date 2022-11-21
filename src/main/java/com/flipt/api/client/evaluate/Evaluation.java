package com.flipt.api.client.evaluate;

import com.fern.java.jersey.contracts.OptionalAwareContract;
import com.flipt.api.client.evaluate.exceptions.BatchEvaluateException;
import com.flipt.api.client.evaluate.exceptions.EvaluateException;
import com.flipt.api.client.evaluate.types.BatchEvaluationRequest;
import com.flipt.api.client.evaluate.types.BatchEvaluationResponse;
import com.flipt.api.client.evaluate.types.EvaluationRequest;
import com.flipt.api.client.evaluate.types.EvaluationResponse;
import com.flipt.api.core.BasicAuth;
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
@Path("/api/v1")
interface Evaluation {
  @POST
  @Path("/evaluate")
  EvaluationResponse evaluate(@HeaderParam("Authorization") BasicAuth auth, EvaluationRequest body)
      throws EvaluateException;

  @POST
  @Path("/batch-evaluate")
  BatchEvaluationResponse batchEvaluate(@HeaderParam("Authorization") BasicAuth auth,
      BatchEvaluationRequest body) throws BatchEvaluateException;

  static Evaluation getClient(String url) {
    return Feign.builder()
        .contract(new OptionalAwareContract(new JAXRSContract()))
        .decoder(new JacksonDecoder(ObjectMappers.JSON_MAPPER))
        .encoder(new JacksonEncoder(ObjectMappers.JSON_MAPPER))
        .errorDecoder(new EvaluationErrorDecoder()).target(Evaluation.class, url);
  }
}
