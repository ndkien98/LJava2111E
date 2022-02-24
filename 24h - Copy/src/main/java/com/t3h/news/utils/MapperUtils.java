package com.t3h.news.utils;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperUtils {

    /**
     * Sử dụng reflect trong java
     */
    public static <T> T mapRow(T object, ResultSet resultSet){

        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field: fields
             ) {
            field.setAccessible(true);
            try {
                Object dataOfField = resultSet.getObject(field.getName(),field.getType());
                if (dataOfField != null){
                    field.set(object,dataOfField);
                }
            } catch (SQLException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return object;
    }

}
