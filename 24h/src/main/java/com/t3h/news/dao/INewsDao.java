package com.t3h.news.dao;

import com.t3h.news.model.NewsModel;

import java.util.List;

public interface INewsDao {

    List<NewsModel> getList();

    NewsModel add(NewsModel newsModel);

    NewsModel findById(Integer id);
}
