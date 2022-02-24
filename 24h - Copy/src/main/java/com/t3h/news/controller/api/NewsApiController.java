package com.t3h.news.controller.api;

import com.t3h.news.model.NewsModel;
import com.t3h.news.service.INewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin/news")
public class NewsApiController {


    private final INewsService iNewsService;

    public NewsApiController(INewsService iNewsService) {
        this.iNewsService = iNewsService;
    }


    @PostMapping()
    public ResponseEntity<NewsModel> add(@RequestBody NewsModel newsModel){
        return ResponseEntity.ok(iNewsService.add(newsModel));
    }

}
