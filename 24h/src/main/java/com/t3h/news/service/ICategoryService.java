package com.t3h.news.service;

import com.t3h.news.model.CategoryModel;

import java.util.List;

public interface ICategoryService {

    List<CategoryModel> getAll();

    void add(CategoryModel categoryModel);

    CategoryModel findById(int id);
}
