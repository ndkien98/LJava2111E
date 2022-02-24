package com.t3h.news.mapper;

import com.t3h.news.model.NewsModel;
import com.t3h.news.utils.MapperUtils;

import java.sql.ResultSet;

public class INewMapper implements IMapper<NewsModel>{
    @Override
    public NewsModel map(ResultSet resultSet) {
        return MapperUtils.mapRow(new NewsModel(),resultSet);
    }
}
