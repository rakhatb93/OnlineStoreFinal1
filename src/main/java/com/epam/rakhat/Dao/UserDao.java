package com.epam.rakhat.Dao;
import com.epam.rakhat.Entities.*;
import com.epam.rakhat.Exceptions.DAOException;

import java.sql.SQLException;

public interface UserDao extends CommonDao<User>{
    User findByName(String name) throws DAOException;
    boolean deleteUser(int userId) throws SQLException;
    boolean alreadyExist(String login);
    int insert(User user);
}
