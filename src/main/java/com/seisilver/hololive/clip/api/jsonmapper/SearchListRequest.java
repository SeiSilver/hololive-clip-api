package com.seisilver.hololive.clip.api.jsonmapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;
import org.springframework.util.ReflectionUtils;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@FieldNameConstants
public class SearchListRequest extends YoutubeAuth {

  private String part;
  private String channelId;
  private String channelType;
  private String eventType;
  private Boolean forContentOwner;
  private Boolean forDeveloper;
  private Boolean forMine;
  private String location;
  private String locationRadius;
  private Long maxResults;
  private String onBehalfOfContentOwner;
  private String order;
  private String pageToken;
  private ZonedDateTime publishedAfter;
  private ZonedDateTime publishedBefore;
  private String q;
  private String regionCode;
  private String relatedToVideoId;
  private String relevanceLanguage;
  private String safeSearch;
  private String topicId;
  private String type;
  private String videoCaption;
  private String videoCategoryId;
  private String videoDefinition;
  private String videoDimension;
  private String videoDuration;
  private String videoEmbeddable;
  private String videoLicense;
  private String videoSyndicated;
  private String videoType;

  public String getParamPath() {
    StringBuilder params = new StringBuilder();
    params.append("?");
    ReflectionUtils.doWithFields(this.getClass(), field -> {
      field.setAccessible(true);
      if (field.get(this) != null) {
        params.append(field.getName())
            .append("=")
            .append(field.get(this))
            .append("&");
      }
    });
    params.deleteCharAt(params.length() - 1);
    return params.toString();
  }

}
