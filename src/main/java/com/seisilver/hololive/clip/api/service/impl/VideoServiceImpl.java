package com.seisilver.hololive.clip.api.service.impl;

import com.seisilver.hololive.clip.api.config.ApplicationProperties;
import com.seisilver.hololive.clip.api.enums.SearchOrder;
import com.seisilver.hololive.clip.api.jsonmapper.SearchListRequest;
import com.seisilver.hololive.clip.api.jsonmapper.SearchListResponse;
import com.seisilver.hololive.clip.api.model.PagingResponseDto;
import com.seisilver.hololive.clip.api.model.YoutubeVideo;
import com.seisilver.hololive.clip.api.service.VideoService;
import com.seisilver.hololive.clip.api.service.YoutubeApiSearch;
import lombok.AllArgsConstructor;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VideoServiceImpl implements VideoService {

  public static final String YOUTUBE_VIDEO_URL = "https://www.youtube.com/watch?v=";
  private final YoutubeApiSearch youtubeApiSearch;
  private final ApplicationProperties applicationProperties;

  @Override
  public PagingResponseDto<YoutubeVideo> crawlVideos(String query, Long size, SearchOrder order, String pageToken) {
    SearchListRequest searchListRequest = SearchListRequest.builder()
        .part("id,snippet")
        .maxResults(size <= 50 ? size : 50L)
        .q(query)
        .type("video")
        .order(order.name())
        .key(applicationProperties.getYoutube().getApiKey())
        .pageToken(pageToken)
        .build();
    SearchListResponse searchListResponse = youtubeApiSearch.searchList(searchListRequest);
    List<YoutubeVideo> videos = searchListResponse.getItems()
        .stream()
        .map((result) -> YoutubeVideo.builder()
            .videoId(result.getId().getVideoId())
            .title(unescape(result.getSnippet().getTitle()))
            .videoUrl(YOUTUBE_VIDEO_URL + result.getId().getVideoId())
            .channelId(result.getSnippet().getChannelId())
            .channelTitle(unescape(result.getSnippet().getChannelTitle()))
            .thumbnail(result.getSnippet().getThumbnails().get_default().getUrl())
            .shortDescription(result.getSnippet().getDescription())
            .publishedAt(result.getSnippet().getPublishedAt())
            .build())
        .collect(Collectors.toList());
    PagingResponseDto<YoutubeVideo> pagingResponseDto = new PagingResponseDto<>();
    pagingResponseDto.setNextPageToken(searchListResponse.getNextPageToken());
    pagingResponseDto.setPrevPageToken(searchListResponse.getPrevPageToken());
    pagingResponseDto.setTotalResults(searchListResponse.getPageInfo().getTotalResults());
    pagingResponseDto.setResultsPerPage(searchListResponse.getPageInfo().getResultsPerPage());
    pagingResponseDto.setResults(videos);
    return pagingResponseDto;
  }

  private String unescape(String value) {
    return StringEscapeUtils.unescapeHtml4(value);
  }

}
