package com.flipt.api.resources.variants;

import com.flipt.api.resources.variants.requests.VariantCreateRequest;
import com.flipt.api.resources.variants.requests.VariantUpdateRequest;
import com.flipt.api.resources.variants.types.Variant;
import java.lang.String;

public interface VariantsClient {
  Variant create(String flagKey, VariantCreateRequest request);

  void delete(String flagKey, String id);

  Variant update(String flagKey, String id, VariantUpdateRequest request);
}
