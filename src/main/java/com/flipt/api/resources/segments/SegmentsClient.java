package com.flipt.api.resources.segments;

import com.flipt.api.resources.segments.requests.SegmentCreateRequest;
import com.flipt.api.resources.segments.requests.SegmentListRequest;
import com.flipt.api.resources.segments.requests.SegmentUpdateRequest;
import com.flipt.api.resources.segments.types.Segment;
import com.flipt.api.resources.segments.types.SegmentList;
import java.lang.String;

public interface SegmentsClient {
  SegmentList list(SegmentListRequest request);

  Segment create(SegmentCreateRequest request);

  Segment get(String key);

  void delete(String key);

  Segment update(String key, SegmentUpdateRequest request);
}
