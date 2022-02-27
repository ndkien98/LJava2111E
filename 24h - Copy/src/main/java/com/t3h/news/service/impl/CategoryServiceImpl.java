package com.t3h.news.service.impl;

import com.t3h.news.dao.ICategoryDao;
import com.t3h.news.model.CategoryModel;
import com.t3h.news.model.entity.CategoryEntity;
import com.t3h.news.service.ICategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements ICategoryService {

    private final ICategoryDao iCategoryDao;

    public CategoryServiceImpl(ICategoryDao iCategoryDao) {
        this.iCategoryDao = iCategoryDao;
    }


    @Override
    public List<CategoryModel> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        return iCategoryDao.findAll().stream().map(data -> modelMapper.map(data,CategoryModel.class)).collect(Collectors.toList());
    }

    @Override
    public CategoryModel add(CategoryModel categoryModel) {
        ModelMapper modelMapper = new ModelMapper();
        CategoryEntity category = iCategoryDao.add(modelMapper.map(categoryModel,CategoryEntity.class));
        return categoryModel;
    }
}
