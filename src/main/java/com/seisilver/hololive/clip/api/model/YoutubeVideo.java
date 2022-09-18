package com.seisilver.hololive.clip.api.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@Builder
public class YoutubeVideo {

  private String videoId;

  private String thumbnail;

  private String title;

  private String videoUrl;

  private String channelId;

  private String channelTitle;

  private String shortDescription;

  private ZonedDateTime publishedAt;

}
