package com.epam.rakhat.Dao.PostgresImpl;

import com.epam.rakhat.Dao.DaoManager.DaoManager;
import com.epam.rakhat.Exceptions.DAOException;
import com.epam.rakhat.Pool.ConnectionPool;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;
import java.util.logging.Logger;

public class DaoFactory {
    
    private static final Logger LOGGER = Logger.getLogger(DaoFactory.class.getName());
    private ConnectionPool pool;
    private String url;
    private String user;
    private String password;
    private int maxConnection;

    public DaoFactory(){
        Properties properties = new Properties();
        String fileName = "dbConnection.properties";
        InputStream inputStream = ConnectionPool.class.getClassLoader().getResourceAsStream(fileName);

        try{
            properties.load(inputStream);
            this.url = properties.getProperty("dburl");
            this.user = properties.getProperty("user");
            this.password = properties.getProperty("password");
            this.maxConnection = Integer.parseInt(properties.getProperty("maxConnection"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DaoManager getDaoManager() throws DAOException{
        Connection connection = null;
        try{
            connection = pool.getConnection();
        } catch (DAOException e) {
            e.printStackTrace();
            throw new DAOException(e);
        }
        return new DaoManager(connection);
    }

    public void putBackConnection(Connection connection){
     pool.addConnectionToPool(connection);
    }

    public static DaoFactory getInstance (){
        return InstanceHolder.instance;
    }

    private static class InstanceHolder{
        private static DaoFactory instance = new DaoFactory();
    }
}

