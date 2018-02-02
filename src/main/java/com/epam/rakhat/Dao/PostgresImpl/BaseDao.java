package com.epam.rakhat.Dao.PostgresImpl;

import com.epam.rakhat.Exceptions.DAOException;

import java.sql.Connection;

abstract class BaseDao <T>{

    private Connection connection = null;

    public BaseDao(Connection connection){
        this.connection = connection;
    }

    public boolean delete() throws DAOException {
        return false;
    };

    public T find() throws DAOException {
      return null;
    };

    public boolean update()throws DAOException {
        return false;
    };

    public boolean create () throws DAOException {
        return false;
    };
}
