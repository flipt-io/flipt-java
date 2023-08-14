package com.flipt.api.resources.namespaces.types;

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
@JsonDeserialize(builder = NamespaceList.Builder.class)
public final class NamespaceList {
    private final List<Namespace> namespaces;

    private final String nextPageToken;

    private final int totalCount;

    private NamespaceList(List<Namespace> namespaces, String nextPageToken, int totalCount) {
        this.namespaces = namespaces;
        this.nextPageToken = nextPageToken;
        this.totalCount = totalCount;
    }

    @JsonProperty("namespaces")
    public List<Namespace> getNamespaces() {
        return namespaces;
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
        return other instanceof NamespaceList && equalTo((NamespaceList) other);
    }

    private boolean equalTo(NamespaceList other) {
        return namespaces.equals(other.namespaces)
                && nextPageToken.equals(other.nextPageToken)
                && totalCount == other.totalCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.namespaces, this.nextPageToken, this.totalCount);
    }

    @Override
    public String toString() {
        return "NamespaceList{" + "namespaces: " + namespaces + ", nextPageToken: " + nextPageToken + ", totalCount: "
                + totalCount + "}";
    }

    public static NextPageTokenStage builder() {
        return new Builder();
    }

    public interface NextPageTokenStage {
        TotalCountStage nextPageToken(String nextPageToken);

        Builder from(NamespaceList other);
    }

    public interface TotalCountStage {
        _FinalStage totalCount(int totalCount);
    }

    public interface _FinalStage {
        NamespaceList build();

        _FinalStage namespaces(List<Namespace> namespaces);

        _FinalStage addNamespaces(Namespace namespaces);

        _FinalStage addAllNamespaces(List<Namespace> namespaces);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NextPageTokenStage, TotalCountStage, _FinalStage {
        private String nextPageToken;

        private int totalCount;

        private List<Namespace> namespaces = new ArrayList<>();

        private Builder() {}

        @Override
        public Builder from(NamespaceList other) {
            namespaces(other.getNamespaces());
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
        public _FinalStage addAllNamespaces(List<Namespace> namespaces) {
            this.namespaces.addAll(namespaces);
            return this;
        }

        @Override
        public _FinalStage addNamespaces(Namespace namespaces) {
            this.namespaces.add(namespaces);
            return this;
        }

        @Override
        @JsonSetter(value = "namespaces", nulls = Nulls.SKIP)
        public _FinalStage namespaces(List<Namespace> namespaces) {
            this.namespaces.clear();
            this.namespaces.addAll(namespaces);
            return this;
        }

        @Override
        public NamespaceList build() {
            return new NamespaceList(namespaces, nextPageToken, totalCount);
        }
    }
}
