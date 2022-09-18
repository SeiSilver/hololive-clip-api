package com.seisilver.hololive.clip.api.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties(prefix = "application")
public class ApplicationProperties {

  private final YoutubeConfig youtube = new YoutubeConfig();

  @Getter
  @Setter
  public static class YoutubeConfig {
    private String apiKey;
    private String searchPath;

  }

}
