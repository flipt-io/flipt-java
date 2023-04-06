package com.flipt.api.resources.rules.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(
    builder = RuleList.Builder.class
)
public final class RuleList {
  private final List<Rule> rules;

  private final String nextPageToken;

  private final int totalCount;

  private int _cachedHashCode;

  RuleList(List<Rule> rules, String nextPageToken, int totalCount) {
    this.rules = rules;
    this.nextPageToken = nextPageToken;
    this.totalCount = totalCount;
  }

  @JsonProperty("rules")
  public List<Rule> getRules() {
    return rules;
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
    return other instanceof RuleList && equalTo((RuleList) other);
  }

  private boolean equalTo(RuleList other) {
    return rules.equals(other.rules) && nextPageToken.equals(other.nextPageToken) && totalCount == other.totalCount;
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.rules, this.nextPageToken, this.totalCount);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "RuleList{" + "rules: " + rules + ", nextPageToken: " + nextPageToken + ", totalCount: " + totalCount + "}";
  }

  public static NextPageTokenStage builder() {
    return new Builder();
  }

  public interface NextPageTokenStage {
    TotalCountStage nextPageToken(String nextPageToken);

    Builder from(RuleList other);
  }

  public interface TotalCountStage {
    _FinalStage totalCount(int totalCount);
  }

  public interface _FinalStage {
    RuleList build();

    _FinalStage rules(List<Rule> rules);

    _FinalStage addRules(Rule rules);

    _FinalStage addAllRules(List<Rule> rules);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements NextPageTokenStage, TotalCountStage, _FinalStage {
    private String nextPageToken;

    private int totalCount;

    private List<Rule> rules = new ArrayList<>();

    private Builder() {
    }

    @Override
    public Builder from(RuleList other) {
      rules(other.getRules());
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
    public _FinalStage addAllRules(List<Rule> rules) {
      this.rules.addAll(rules);
      return this;
    }

    @Override
    public _FinalStage addRules(Rule rules) {
      this.rules.add(rules);
      return this;
    }

    @Override
    @JsonSetter(
        value = "rules",
        nulls = Nulls.SKIP
    )
    public _FinalStage rules(List<Rule> rules) {
      this.rules.clear();
      this.rules.addAll(rules);
      return this;
    }

    @Override
    public RuleList build() {
      return new RuleList(rules, nextPageToken, totalCount);
    }
  }
}
