package com.flipt.api.resources.namespaces;

import com.flipt.api.resources.namespaces.requests.NamespaceListRequest;
import com.flipt.api.resources.namespaces.types.Namespace;
import com.flipt.api.resources.namespaces.types.NamespaceCreateRequest;
import com.flipt.api.resources.namespaces.types.NamespaceList;
import com.flipt.api.resources.namespaces.types.NamespaceUpdateRequest;
import java.lang.String;

public interface NamespacesClient {
  NamespaceList list(NamespaceListRequest request);

  Namespace create(NamespaceCreateRequest request);

  Namespace get(String key);

  void delete(String key);

  Namespace update(String key, NamespaceUpdateRequest request);
}
