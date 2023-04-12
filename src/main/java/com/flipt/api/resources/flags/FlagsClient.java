package com.flipt.api.resources.flags;

import com.flipt.api.resources.flags.requests.FlagListRequest;
import com.flipt.api.resources.flags.types.Flag;
import com.flipt.api.resources.flags.types.FlagCreateRequest;
import com.flipt.api.resources.flags.types.FlagList;
import com.flipt.api.resources.flags.types.FlagUpdateRequest;
import java.lang.String;

public interface FlagsClient {
  FlagList list(String namespaceKey, FlagListRequest request);

  Flag create(String namespaceKey, FlagCreateRequest request);

  Flag get(String namespaceKey, String key);

  void delete(String namespaceKey, String key);

  Flag update(String namespaceKey, String key, FlagUpdateRequest request);
}
