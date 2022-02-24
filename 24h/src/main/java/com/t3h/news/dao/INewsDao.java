package com.t3h.news.dao;

import com.t3h.news.model.NewsModel;

import java.util.List;

public interface NewsDao extends IGenericDao<NewsModel> {

    List<NewsModel> getList();
}
