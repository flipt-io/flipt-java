package com.flipt.api.resources.flags;

import com.flipt.api.resources.flags.requests.FlagCreateRequest;
import com.flipt.api.resources.flags.requests.FlagListRequest;
import com.flipt.api.resources.flags.requests.FlagUpdateRequest;
import com.flipt.api.resources.flags.types.Flag;
import com.flipt.api.resources.flags.types.FlagList;
import java.lang.String;

public interface FlagsClient {
  FlagList list(FlagListRequest request);

  Flag create(FlagCreateRequest request);

  Flag get(String key);

  void delete(String key);

  Flag update(String key, FlagUpdateRequest request);
}
