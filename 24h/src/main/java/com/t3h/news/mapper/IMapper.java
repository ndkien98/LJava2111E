package com.t3h.news.mapper;

import java.sql.ResultSet;

public interface IMapper <T>{

    T map(ResultSet resultSet);
}
