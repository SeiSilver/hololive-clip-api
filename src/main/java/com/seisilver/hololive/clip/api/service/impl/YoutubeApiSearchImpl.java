package com.seisilver.hololive.clip.api.service.impl;

import com.seisilver.hololive.clip.api.config.ApplicationProperties;
import com.seisilver.hololive.clip.api.jsonmapper.SearchListRequest;
import com.seisilver.hololive.clip.api.jsonmapper.SearchListResponse;
import com.seisilver.hololive.clip.api.service.YoutubeApiSearch;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class YoutubeApiSearchImpl implements YoutubeApiSearch {

  private final RestTemplate restTemplate;
  private final ApplicationProperties applicationProperties;

  @Override
  public SearchListResponse searchList(SearchListRequest searchListRequest) {
    return restTemplate.getForObject(applicationProperties.getYoutube().getSearchPath() + searchListRequest.getParamPath(),
        SearchListResponse.class, searchListRequest);
  }

}
