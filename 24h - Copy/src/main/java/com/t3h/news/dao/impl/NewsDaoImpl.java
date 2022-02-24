package com.t3h.news.dao.impl;

import com.t3h.news.dao.INewsDao;
import com.t3h.news.mapper.NewMapper;
import com.t3h.news.model.NewsModel;

import java.sql.*;
import java.util.List;

public class NewsDaoImpl extends GenericDaoImpl<NewsModel> implements INewsDao {

    public NewsModel add(NewsModel newsModel){

        Connection connection = getConnection();

        String sql = "insert into news (title,author,originalResource,content,numberAccess) value (?,?,?,?,?)";

        PreparedStatement preparedStatement = null;

        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            // set giá trị insert
            preparedStatement.setString(1,newsModel.getTitle());
            preparedStatement.setString(2,newsModel.getAuthor());
            preparedStatement.setString(3,newsModel.getOriginalResource());
            preparedStatement.setString(4,newsModel.getContent());
            preparedStatement.setInt(5,0);

            // thực thi query
            preparedStatement.executeUpdate();

            // commit
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return newsModel;
    }


    @Override
    public List<NewsModel> getList() {
        String sql = "select * from news";
        return findByProperties(sql,new NewMapper());
    }
}
