package com.seisilver.hololive.clip.api.jsonmapper;

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
public class SearchListResponse {

  private String kind;
  private String etag;
  private List<SearchResult> items;
  private String nextPageToken;
  private String prevPageToken;
  private PageInfo pageInfo;
  private String regionCode;

  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  @Builder
  public static class PageInfo {
    private Integer resultsPerPage;
    private Integer totalResults;
  }

}
