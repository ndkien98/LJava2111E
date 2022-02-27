package com.t3h.news.dao.impl;

import com.t3h.news.dao.INewsDao;
import com.t3h.news.mapper.NewMapper;
import com.t3h.news.model.entity.NewsEntity;

import java.sql.*;
import java.util.List;

public class NewsDaoImpl extends GenericDaoImpl<NewsEntity> implements INewsDao {

    public NewsEntity add(NewsEntity newsEntity){

        Connection connection = getConnection();

        String sql = "insert into news (title,author,originalResource,content,numberAccess) value (?,?,?,?,?)";

        PreparedStatement preparedStatement = null;

        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            // set giá trị insert
            preparedStatement.setString(1,newsEntity.getTitle());
            preparedStatement.setString(2,newsEntity.getAuthor());
            preparedStatement.setString(3,newsEntity.getOriginalResource());
            preparedStatement.setString(4,newsEntity.getContent());
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
        return newsEntity;
    }

    @Override
    public NewsEntity findById(int id) {
        return null;
    }


    @Override
    public List<NewsEntity> getList() {
        String sql = "select * from news";
        return findByProperties(sql,new NewMapper());
    }
}
