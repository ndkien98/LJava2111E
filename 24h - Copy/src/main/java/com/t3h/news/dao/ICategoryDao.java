package com.t3h.news.dao;

import com.t3h.news.model.entity.CategoryEntity;

import java.util.List;

public interface ICategoryDao {

    CategoryEntity findById(int id);

    List<CategoryEntity> findAll();

    CategoryEntity add(CategoryEntity category);
}
