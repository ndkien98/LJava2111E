package com.t3h.news.dao.implJdbc;

import com.t3h.news.dao.IGenericDao;
import com.t3h.news.mapper.IMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC: kết nối và làm việc với cơ sở dữ liệu
 *
 * - tạo trước database
 * - tự mapping dữ liệu dạng table từ database -> object trong java
 * - tự quản lý transaction
 *
 * ORM, hibernate
 * ORM: Object Relational Mapping
 * - tự đọng mapping dữ liệu từ object -> table trong database và ngược lại
 *
 * hibernate: là 1 framewok để làm với với database được phát triển từ JDBC
 * - tự động quản lý transaction
 * - tự động đóng session
 * - cung cấp các hàm xử lý chung khi thap tác với cơ sở dữ liệu
 *
 */
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
            this.rollback(connection);
        }finally {
            closeConnection(connection);
            closePreparedStatement(preparedStatement);
        }
        return resultModel;
    }

    @Override
    public void insert(String sql, Object... parameter) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            this.setValueFromParameter(preparedStatement,parameter);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            this.rollback(connection);
        }finally {
            this.closeConnection(connection);
            closePreparedStatement(preparedStatement);
        }

    }

    private void closePreparedStatement(PreparedStatement preparedStatement) {
        try {
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setValueFromParameter(PreparedStatement preparedStatement, Object[] parameteres) throws SQLException {
        for (int i = 0; i < parameteres.length; i++) {
            int index = i + 1;
            Object dataInArray = parameteres[i];
            if (dataInArray instanceof String){
                preparedStatement.setString(index, dataInArray.toString());
            }else if (dataInArray instanceof Integer){
                preparedStatement.setInt(index,Integer.parseInt(dataInArray.toString()));
            }else if (dataInArray instanceof Boolean){
                preparedStatement.setBoolean(index,Boolean.parseBoolean(dataInArray.toString()));
            }else if (dataInArray instanceof Timestamp){
                preparedStatement.setTimestamp(index,Timestamp.valueOf(dataInArray.toString()));
            }
        }
    }

    private void rollback(Connection connection){
        try {
            connection.rollback();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
