package com.t3h.news.dao.impl;

import com.t3h.news.dao.IGenericDao;
import com.t3h.news.mapper.IMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericDaoImpl<T> implements IGenericDao {

    public Connection getConnection(){
        String url = "jdbc:mysql://localhost:3306/24h";
        String username = "root";
        String password = "1234"; // dien password cua mysql may ca nhan
        try {
            // load drive
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<T> findByProperties(String sql, IMapper iMapper, Object... parameteres) {

        Connection connection = getConnection();

        PreparedStatement preparedStatement = null;
        List<T> resultModel = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            setValueFromParameter(preparedStatement, parameteres);
            resultSet = preparedStatement.executeQuery();

            // mapping data from table to object java
            while (resultSet.next()) {
                T object = (T) iMapper.map(resultSet);
                resultModel.add(object);
            }
        
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
        return resultModel;
    }

    @Override
    public void insert(String sql, Object... parameter) {

    }

    private void setValueFromParameter(PreparedStatement preparedStatement, Object[] parameteres) throws SQLException {
        for (int i = 1; i <= parameteres.length; i++) {
            if (parameteres[i] instanceof String){
                preparedStatement.setString(i, parameteres[i].toString());
            }else if (parameteres[i] instanceof Integer){
                preparedStatement.setInt(i,Integer.parseInt(parameteres[i].toString()));
            }else if (parameteres[i] instanceof Boolean){
                preparedStatement.setBoolean(i,Boolean.parseBoolean(parameteres[i].toString()));
            }else if (parameteres[i] instanceof Timestamp){
                preparedStatement.setTimestamp(i,Timestamp.valueOf(parameteres[i].toString()));
            }
        }
    }
}
