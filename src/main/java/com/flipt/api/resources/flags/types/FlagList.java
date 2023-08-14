package com.flipt.api.resources.flags.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = FlagList.Builder.class)
public final class FlagList {
    private final List<Flag> flags;

    private final String nextPageToken;

    private final int totalCount;

    private FlagList(List<Flag> flags, String nextPageToken, int totalCount) {
        this.flags = flags;
        this.nextPageToken = nextPageToken;
        this.totalCount = totalCount;
    }

    @JsonProperty("flags")
    public List<Flag> getFlags() {
        return flags;
    }

    @JsonProperty("nextPageToken")
    public String getNextPageToken() {
        return nextPageToken;
    }

    @JsonProperty("totalCount")
    public int getTotalCount() {
        return totalCount;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof FlagList && equalTo((FlagList) other);
    }

    private boolean equalTo(FlagList other) {
        return flags.equals(other.flags) && nextPageToken.equals(other.nextPageToken) && totalCount == other.totalCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.flags, this.nextPageToken, this.totalCount);
    }

    @Override
    public String toString() {
        return "FlagList{" + "flags: " + flags + ", nextPageToken: " + nextPageToken + ", totalCount: " + totalCount
                + "}";
    }

    public static NextPageTokenStage builder() {
        return new Builder();
    }

    public interface NextPageTokenStage {
        TotalCountStage nextPageToken(String nextPageToken);

        Builder from(FlagList other);
    }

    public interface TotalCountStage {
        _FinalStage totalCount(int totalCount);
    }

    public interface _FinalStage {
        FlagList build();

        _FinalStage flags(List<Flag> flags);

        _FinalStage addFlags(Flag flags);

        _FinalStage addAllFlags(List<Flag> flags);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NextPageTokenStage, TotalCountStage, _FinalStage {
        private String nextPageToken;

        private int totalCount;

        private List<Flag> flags = new ArrayList<>();

        private Builder() {}

        @Override
        public Builder from(FlagList other) {
            flags(other.getFlags());
            nextPageToken(other.getNextPageToken());
            totalCount(other.getTotalCount());
            return this;
        }

        @Override
        @JsonSetter("nextPageToken")
        public TotalCountStage nextPageToken(String nextPageToken) {
            this.nextPageToken = nextPageToken;
            return this;
        }

        @Override
        @JsonSetter("totalCount")
        public _FinalStage totalCount(int totalCount) {
            this.totalCount = totalCount;
            return this;
        }

        @Override
        public _FinalStage addAllFlags(List<Flag> flags) {
            this.flags.addAll(flags);
            return this;
        }

        @Override
        public _FinalStage addFlags(Flag flags) {
            this.flags.add(flags);
            return this;
        }

        @Override
        @JsonSetter(value = "flags", nulls = Nulls.SKIP)
        public _FinalStage flags(List<Flag> flags) {
            this.flags.clear();
            this.flags.addAll(flags);
            return this;
        }

        @Override
        public FlagList build() {
            return new FlagList(flags, nextPageToken, totalCount);
        }
    }
}
