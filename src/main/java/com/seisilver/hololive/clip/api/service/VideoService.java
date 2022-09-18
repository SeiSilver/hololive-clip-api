package com.seisilver.hololive.clip.api.service;

import com.seisilver.hololive.clip.api.enums.SearchOrder;
import com.seisilver.hololive.clip.api.model.PagingResponseDto;
import com.seisilver.hololive.clip.api.model.YoutubeVideo;

public interface VideoService {

  PagingResponseDto<YoutubeVideo> crawlVideos(String query, Long size, SearchOrder order, String pageToken);
}
