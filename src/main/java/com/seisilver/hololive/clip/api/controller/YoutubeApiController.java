package com.seisilver.hololive.clip.api.controller;

import com.seisilver.hololive.clip.api.enums.HololiveTalents;
import com.seisilver.hololive.clip.api.enums.SearchOrder;
import com.seisilver.hololive.clip.api.service.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class YoutubeApiController {

  private final VideoService videoService;

  @GetMapping("/clips/api/search")
  public Object search(@RequestParam String query, @RequestParam(defaultValue = "50", required = false) Long size,
                       @RequestParam(defaultValue = "date", required = false) SearchOrder orderBy, @RequestParam(required = false) String pageToken) {

    StringBuilder queryNew = new StringBuilder();
    queryNew.append(query);
    HololiveTalents[] talents = HololiveTalents.values();
    for (var talent : talents) {
      if (query.toLowerCase().contains(talent.name().toLowerCase())) {
        queryNew.append("+");
        queryNew.append(talent.name());
      }
    }
    queryNew.append(" hololive +sub");
    return videoService.crawlVideos(queryNew.toString(), size, orderBy, pageToken);
  }

}
