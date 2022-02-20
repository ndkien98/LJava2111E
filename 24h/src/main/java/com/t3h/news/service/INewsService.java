package com.t3h.news.service;

import com.t3h.news.model.NewsModel;

import java.util.List;

public interface INewsService {

    List<NewsModel> getList();

    NewsModel add(NewsModel newsModel);

    NewsModel findById(Integer id);
}
