package com.flipt.api.resources.evaluate.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.OffsetDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = EvaluationResponse.Builder.class)
public final class EvaluationResponse {
    private final String requestId;

    private final String entityId;

    private final Map<String, String> requestContext;

    private final boolean match;

    private final String flagKey;

    private final String segmentKey;

    private final OffsetDateTime timestamp;

    private final String value;

    private final double requestDurationMillis;

    private final String attachment;

    private final EvaluationReason reason;

    private EvaluationResponse(
            String requestId,
            String entityId,
            Map<String, String> requestContext,
            boolean match,
            String flagKey,
            String segmentKey,
            OffsetDateTime timestamp,
            String value,
            double requestDurationMillis,
            String attachment,
            EvaluationReason reason) {
        this.requestId = requestId;
        this.entityId = entityId;
        this.requestContext = requestContext;
        this.match = match;
        this.flagKey = flagKey;
        this.segmentKey = segmentKey;
        this.timestamp = timestamp;
        this.value = value;
        this.requestDurationMillis = requestDurationMillis;
        this.attachment = attachment;
        this.reason = reason;
    }

    @JsonProperty("requestId")
    public String getRequestId() {
        return requestId;
    }

    @JsonProperty("entityId")
    public String getEntityId() {
        return entityId;
    }

    @JsonProperty("requestContext")
    public Map<String, String> getRequestContext() {
        return requestContext;
    }

    @JsonProperty("match")
    public boolean getMatch() {
        return match;
    }

    @JsonProperty("flagKey")
    public String getFlagKey() {
        return flagKey;
    }

    @JsonProperty("segmentKey")
    public String getSegmentKey() {
        return segmentKey;
    }

    @JsonProperty("timestamp")
    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("requestDurationMillis")
    public double getRequestDurationMillis() {
        return requestDurationMillis;
    }

    @JsonProperty("attachment")
    public String getAttachment() {
        return attachment;
    }

    @JsonProperty("reason")
    public EvaluationReason getReason() {
        return reason;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof EvaluationResponse && equalTo((EvaluationResponse) other);
    }

    private boolean equalTo(EvaluationResponse other) {
        return requestId.equals(other.requestId)
                && entityId.equals(other.entityId)
                && requestContext.equals(other.requestContext)
                && match == other.match
                && flagKey.equals(other.flagKey)
                && segmentKey.equals(other.segmentKey)
                && timestamp.equals(other.timestamp)
                && value.equals(other.value)
                && requestDurationMillis == other.requestDurationMillis
                && attachment.equals(other.attachment)
                && reason.equals(other.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.requestId,
                this.entityId,
                this.requestContext,
                this.match,
                this.flagKey,
                this.segmentKey,
                this.timestamp,
                this.value,
                this.requestDurationMillis,
                this.attachment,
                this.reason);
    }

    @Override
    public String toString() {
        return "EvaluationResponse{" + "requestId: " + requestId + ", entityId: " + entityId + ", requestContext: "
                + requestContext + ", match: " + match + ", flagKey: " + flagKey + ", segmentKey: " + segmentKey
                + ", timestamp: " + timestamp + ", value: " + value + ", requestDurationMillis: "
                + requestDurationMillis + ", attachment: " + attachment + ", reason: " + reason + "}";
    }

    public static RequestIdStage builder() {
        return new Builder();
    }

    public interface RequestIdStage {
        EntityIdStage requestId(String requestId);

        Builder from(EvaluationResponse other);
    }

    public interface EntityIdStage {
        MatchStage entityId(String entityId);
    }

    public interface MatchStage {
        FlagKeyStage match(boolean match);
    }

    public interface FlagKeyStage {
        SegmentKeyStage flagKey(String flagKey);
    }

    public interface SegmentKeyStage {
        TimestampStage segmentKey(String segmentKey);
    }

    public interface TimestampStage {
        ValueStage timestamp(OffsetDateTime timestamp);
    }

    public interface ValueStage {
        RequestDurationMillisStage value(String value);
    }

    public interface RequestDurationMillisStage {
        AttachmentStage requestDurationMillis(double requestDurationMillis);
    }

    public interface AttachmentStage {
        ReasonStage attachment(String attachment);
    }

    public interface ReasonStage {
        _FinalStage reason(EvaluationReason reason);
    }

    public interface _FinalStage {
        EvaluationResponse build();

        _FinalStage requestContext(Map<String, String> requestContext);

        _FinalStage putAllRequestContext(Map<String, String> requestContext);

        _FinalStage requestContext(String key, String value);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements RequestIdStage,
                    EntityIdStage,
                    MatchStage,
                    FlagKeyStage,
                    SegmentKeyStage,
                    TimestampStage,
                    ValueStage,
                    RequestDurationMillisStage,
                    AttachmentStage,
                    ReasonStage,
                    _FinalStage {
        private String requestId;

        private String entityId;

        private boolean match;

        private String flagKey;

        private String segmentKey;

        private OffsetDateTime timestamp;

        private String value;

        private double requestDurationMillis;

        private String attachment;

        private EvaluationReason reason;

        private Map<String, String> requestContext = new LinkedHashMap<>();

        private Builder() {}

        @Override
        public Builder from(EvaluationResponse other) {
            requestId(other.getRequestId());
            entityId(other.getEntityId());
            requestContext(other.getRequestContext());
            match(other.getMatch());
            flagKey(other.getFlagKey());
            segmentKey(other.getSegmentKey());
            timestamp(other.getTimestamp());
            value(other.getValue());
            requestDurationMillis(other.getRequestDurationMillis());
            attachment(other.getAttachment());
            reason(other.getReason());
            return this;
        }

        @Override
        @JsonSetter("requestId")
        public EntityIdStage requestId(String requestId) {
            this.requestId = requestId;
            return this;
        }

        @Override
        @JsonSetter("entityId")
        public MatchStage entityId(String entityId) {
            this.entityId = entityId;
            return this;
        }

        @Override
        @JsonSetter("match")
        public FlagKeyStage match(boolean match) {
            this.match = match;
            return this;
        }

        @Override
        @JsonSetter("flagKey")
        public SegmentKeyStage flagKey(String flagKey) {
            this.flagKey = flagKey;
            return this;
        }

        @Override
        @JsonSetter("segmentKey")
        public TimestampStage segmentKey(String segmentKey) {
            this.segmentKey = segmentKey;
            return this;
        }

        @Override
        @JsonSetter("timestamp")
        public ValueStage timestamp(OffsetDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        @Override
        @JsonSetter("value")
        public RequestDurationMillisStage value(String value) {
            this.value = value;
            return this;
        }

        @Override
        @JsonSetter("requestDurationMillis")
        public AttachmentStage requestDurationMillis(double requestDurationMillis) {
            this.requestDurationMillis = requestDurationMillis;
            return this;
        }

        @Override
        @JsonSetter("attachment")
        public ReasonStage attachment(String attachment) {
            this.attachment = attachment;
            return this;
        }

        @Override
        @JsonSetter("reason")
        public _FinalStage reason(EvaluationReason reason) {
            this.reason = reason;
            return this;
        }

        @Override
        public _FinalStage requestContext(String key, String value) {
            this.requestContext.put(key, value);
            return this;
        }

        @Override
        public _FinalStage putAllRequestContext(Map<String, String> requestContext) {
            this.requestContext.putAll(requestContext);
            return this;
        }

        @Override
        @JsonSetter(value = "requestContext", nulls = Nulls.SKIP)
        public _FinalStage requestContext(Map<String, String> requestContext) {
            this.requestContext.clear();
            this.requestContext.putAll(requestContext);
            return this;
        }

        @Override
        public EvaluationResponse build() {
            return new EvaluationResponse(
                    requestId,
                    entityId,
                    requestContext,
                    match,
                    flagKey,
                    segmentKey,
                    timestamp,
                    value,
                    requestDurationMillis,
                    attachment,
                    reason);
        }
    }
}
