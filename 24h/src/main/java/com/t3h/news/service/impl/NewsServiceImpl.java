package com.t3h.news.service.impl;

import com.t3h.news.dao.INewsDao;
import com.t3h.news.dao.implJdbc.NewsDaoImpl;
import com.t3h.news.model.NewsModel;
import com.t3h.news.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class NewsServiceImpl implements INewsService {

    @Autowired
    private INewsDao iNewsDao;


    @Override
    public List<NewsModel> getList() {
        return iNewsDao.getList();
    }

    @Override
    public NewsModel add(NewsModel newsModel) {
        INewsDao iNewsDao = new NewsDaoImpl();
        newsModel.setCreateDate(new Timestamp(System.currentTimeMillis()));
        newsModel.setUpdateDate(new Timestamp(System.currentTimeMillis()));
        newsModel.setNumberAccess(0);
        newsModel.setCreatorId(1);
        newsModel.setEditorId(1);
        newsModel.setCensor(1);
        return iNewsDao.add(newsModel);
    }

    @Override
    public NewsModel findById(Integer id) {
        INewsDao iNewsDao = new NewsDaoImpl();
        return iNewsDao.findById(id);
    }
}
