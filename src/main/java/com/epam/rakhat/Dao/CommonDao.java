package com.epam.rakhat.Dao;

import com.epam.rakhat.Exceptions.DAOException;

public interface CommonDao<T> {
     boolean delete()throws DAOException;
     T find()throws DAOException;
     boolean update()throws DAOException;
     boolean create()throws DAOException;
}
