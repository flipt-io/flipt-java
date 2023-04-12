package com.flipt.api.resources.variants;

import com.flipt.api.resources.variants.types.Variant;
import com.flipt.api.resources.variants.types.VariantCreateRequest;
import com.flipt.api.resources.variants.types.VariantUpdateRequest;
import java.lang.String;

public interface VariantsClient {
  Variant create(String namespaceKey, String flagKey, VariantCreateRequest request);

  void delete(String namespaceKey, String flagKey, String id);

  Variant update(String namespaceKey, String flagKey, String id, VariantUpdateRequest request);
}
