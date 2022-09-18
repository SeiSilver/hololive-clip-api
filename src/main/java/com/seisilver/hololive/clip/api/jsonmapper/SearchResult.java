package com.seisilver.hololive.clip.api.jsonmapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchResult {

  private String etag;
  private ResourceId id;
  private String kind;
  private SearchResultSnippet snippet;

  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  @Builder
  public static class SearchResultSnippet {
    private String channelId;
    private String channelTitle;
    private String description;
    private String liveBroadcastContent;
    private ZonedDateTime publishedAt;
    private ThumbnailDetails thumbnails;
    private String title;
  }

  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  @Builder
  public static class ResourceId {
    private String channelId;
    private String kind;
    private String playlistId;
    private String videoId;
  }


}
