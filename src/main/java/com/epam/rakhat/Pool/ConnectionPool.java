package com.epam.rakhat.Pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private static final int MAX_POOL_CAPACITY = 1000;
    private static int currentPoolSize;
    private static ArrayList<Connection> connectionList = new ArrayList<>(MAX_POOL_CAPACITY);

    public ConnectionPool(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static synchronized Connection getConnectionFromPool(String url, String username, String password)
            throws SQLException {
        if (connectionList.isEmpty()){
            if(currentPoolSize>=MAX_POOL_CAPACITY){
                System.out.println("The pool is full. Can not create new connection.");
            }
            currentPoolSize++;
            return DriverManager.getConnection(url, username, password);
        }else{
            currentPoolSize--;
            return connectionList.remove(0);
        }
    }

    public Connection getConnection() {
        Connection connection = connectionList.get(connectionList.size()-1);
        connectionList.remove(connectionList.size()-1);
        return connection;
    }

    public static synchronized void addConnectionToPool(Connection connection){
        connectionList.add(connection);
    }
}
