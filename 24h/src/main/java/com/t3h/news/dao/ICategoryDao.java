package com.t3h.news.dao;

import com.t3h.news.model.entity.CategoryEntity;

import java.util.List;

public interface ICategoryDao {

    List<CategoryEntity> getAll();

    CategoryEntity add(CategoryEntity categoryEntity);

    CategoryEntity findById(int id);

}
