package com.vladimir.spring.Liquibase;

import com.vladimir.spring.Database.Db;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class MigrationStart {
    public static void main(String[] args) throws RuntimeException {
        Db db = new Db();
        try{
            Connection connection = db.getConnection();
            System.out.println("Connect is successfully");
            Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));
            Liquibase liquibase = new Liquibase("db.changelog/changelog.xml", new ClassLoaderResourceAccessor(), database);
            liquibase.update();
            System.out.println("Migration is completed successfully");

        } catch (SQLException | IOException | LiquibaseException e) {
            throw new RuntimeException(e);

        }
    }
}
