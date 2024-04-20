package com.vladimir.spring.Database;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class Db {

    /**
     * Создание подключения к базе данных
     * @return
     * @throws IOException
     * @throws SQLException
     */
    public Connection getConnection() throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/resources/application.properties"));

        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        return DriverManager.getConnection(url,username,password);
    }




































}
