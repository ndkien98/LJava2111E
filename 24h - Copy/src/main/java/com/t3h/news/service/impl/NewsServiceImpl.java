package com.t3h.news.service.impl;

import com.t3h.news.dao.INewsDao;
import com.t3h.news.dao.impl.NewsDaoImpl;
import com.t3h.news.model.NewsModel;
import com.t3h.news.service.INewsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements INewsService {

    @Override
    public List<NewsModel> getList() {
        INewsDao iNewsDao = new NewsDaoImpl();
        return iNewsDao.getList();
    }

    @Override
    public NewsModel add(NewsModel newsModel) {
        INewsDao iNewsDao = new NewsDaoImpl();
        return iNewsDao.add(newsModel);
    }
}
