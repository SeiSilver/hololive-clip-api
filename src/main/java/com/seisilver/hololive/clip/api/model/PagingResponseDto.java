package com.seisilver.hololive.clip.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagingResponseDto<T> {

  private String nextPageToken;
  private String prevPageToken;
  private Integer resultsPerPage;
  private Integer totalResults;
  private List<T> results;

}
