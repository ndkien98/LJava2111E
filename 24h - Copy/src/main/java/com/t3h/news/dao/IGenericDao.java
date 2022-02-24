package com.t3h.news.dao;

import com.t3h.news.mapper.IMapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public interface IGenericDao <T extends Object> {

    List<T> findByProperties(String sql, IMapper<T> iMapper, Object ...parameter);

    void insert(String sql,Object ...parameter);
}
