package com.t3h.news.service.impl;

import com.t3h.news.dao.ICategoryDao;
import com.t3h.news.dao.INewsDao;
import com.t3h.news.model.NewsModel;
import com.t3h.news.model.entity.CategoryEntity;
import com.t3h.news.model.entity.NewsEntity;
import com.t3h.news.service.INewsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsServiceImpl implements INewsService {

    private final INewsDao iNewsDao;
    private final ICategoryDao iCategoryDao;
    public NewsServiceImpl(INewsDao iNewsDao, ICategoryDao iCategoryDao) {
        this.iNewsDao = iNewsDao;
        this.iCategoryDao = iCategoryDao;
    }


    @Override
    public List<NewsModel> getList() {

        ModelMapper modelMapper = new ModelMapper();
        List<NewsEntity> entities = iNewsDao.getList();
        return entities.stream().map(data -> modelMapper.map(data,NewsModel.class)).collect(Collectors.toList());
    }

    @Override
    public NewsModel add(NewsModel newsModel) {
        ModelMapper modelMapper = new ModelMapper();
        NewsEntity newsEntity = modelMapper.map(newsModel,NewsEntity.class);

        CategoryEntity category = iCategoryDao.findById(newsModel.getCategoryId());
        newsEntity.setCategory(category);
        iNewsDao.add(newsEntity);
        return newsModel;
    }

    @Override
    public NewsModel findById(int id) {

        NewsEntity newsEntity = iNewsDao.findById(id);
        ModelMapper modelMapper = new ModelMapper();
        NewsModel newsModel = modelMapper.map(newsEntity,NewsModel.class);
        newsModel.setCategoryName(newsEntity.getCategory().getName());
        return newsModel;
    }
}
