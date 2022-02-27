package com.t3h.news.service;

import com.t3h.news.model.CategoryModel;
import com.t3h.news.model.entity.CategoryEntity;

import java.util.List;

public interface ICategoryService {

    List<CategoryModel> findAll();

    CategoryModel add(CategoryModel categoryModel);

}
