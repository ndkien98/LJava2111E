package com.t3h.news.dao;

import com.t3h.news.model.NewsModel;
import com.t3h.news.model.entity.NewsEntity;

import java.util.List;

public interface INewsDao {

    List<NewsEntity> getList();

    NewsEntity add(NewsEntity newsEntity);

    NewsEntity findById(int id);
}
