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

    /**
     * Restful api
     */
    @GetMapping()
    public ResponseEntity<NewsModel> findById(@RequestParam Integer id){
        return ResponseEntity.ok(iNewsService.findById(id));
    }

    @PostMapping()
    public ResponseEntity<NewsModel> add(@RequestBody NewsModel newsModel){
        return ResponseEntity.ok(iNewsService.add(newsModel));
    }

}
