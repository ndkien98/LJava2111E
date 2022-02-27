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
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(ICategoryDao iCategoryDao, ModelMapper modelMapper) {
        this.iCategoryDao = iCategoryDao;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<CategoryModel> getAll() {

        List<CategoryEntity> categoryEntities = iCategoryDao.getAll();

        return categoryEntities.stream().map(entity -> modelMapper.map(entity,CategoryModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void add(CategoryModel categoryModel) {

        CategoryEntity categoryEntity = modelMapper.map(categoryModel,CategoryEntity.class);

        iCategoryDao.add(categoryEntity);
    }

    @Override
    public CategoryModel findById(int id) {

        CategoryEntity categoryEntity = iCategoryDao.findById(id);
        return modelMapper.map(categoryEntity,CategoryModel.class);
    }
}
