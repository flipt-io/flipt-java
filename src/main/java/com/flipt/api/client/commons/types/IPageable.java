package com.flipt.api.client.commons.types;

import java.lang.String;

public interface IPageable {
  String getNextPageToken();

  int getTotalCount();
}
