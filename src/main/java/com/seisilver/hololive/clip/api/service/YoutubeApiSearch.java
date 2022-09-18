package com.seisilver.hololive.clip.api.service;

import com.seisilver.hololive.clip.api.jsonmapper.SearchListRequest;
import com.seisilver.hololive.clip.api.jsonmapper.SearchListResponse;

public interface YoutubeApiSearch {

  SearchListResponse searchList(SearchListRequest searchListRequest);

}
