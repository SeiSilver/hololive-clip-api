package com.seisilver.hololive.clip.api.jsonmapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ThumbnailDetails {

  @JsonProperty("default")
  private Thumbnail _default;
  private Thumbnail high;
  private Thumbnail maxres;
  private Thumbnail medium;
  private Thumbnail standard;

  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  @Builder
  public static class Thumbnail {
    private Long height;
    private String url;
    private Long width;
  }

}
