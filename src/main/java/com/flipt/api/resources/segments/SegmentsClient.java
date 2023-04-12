package com.flipt.api.resources.segments;

import com.flipt.api.resources.segments.requests.SegmentListRequest;
import com.flipt.api.resources.segments.types.Segment;
import com.flipt.api.resources.segments.types.SegmentCreateRequest;
import com.flipt.api.resources.segments.types.SegmentList;
import com.flipt.api.resources.segments.types.SegmentUpdateRequest;
import java.lang.String;

public interface SegmentsClient {
  SegmentList list(String namespaceKey, SegmentListRequest request);

  Segment create(String namespaceKey, SegmentCreateRequest request);

  Segment get(String namespaceKey, String key);

  void delete(String namespaceKey, String key);

  Segment update(String namespaceKey, String key, SegmentUpdateRequest request);
}
