package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/userbase?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static Connection connection;
    private static SessionFactory sessionFactory;

    private static void createSessionFactory(){
        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

        Configuration config = new Configuration();
        config.addAnnotatedClass(User.class);
        config.setProperty(Environment.URL, URL);
        config.setProperty(Environment.USER, USER);
        config.setProperty(Environment.PASS, PASSWORD);
        config.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
        config.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        config.setProperty(Environment.HBM2DDL_AUTO,"update");

        registryBuilder.applySettings(config.getProperties());
        StandardServiceRegistry standardServiceRegistry = registryBuilder.build();
        sessionFactory = config.buildSessionFactory(standardServiceRegistry);
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null){
            createSessionFactory();
        }
        return sessionFactory;
    }

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
