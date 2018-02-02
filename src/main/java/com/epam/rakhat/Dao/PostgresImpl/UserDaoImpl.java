package com.epam.rakhat.Dao.PostgresImpl;

import com.epam.rakhat.Exceptions.DAOException;
import com.epam.rakhat.Dao.UserDao;
import com.epam.rakhat.Entities.User;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;



public class UserDaoImpl extends BaseDao<User> implements UserDao {

    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class.getName());
    private Connection connection;

    public UserDaoImpl(Connection connection){
        super(connection);
        this.connection = connection;
    }

    public boolean findByLogin(String login){
        return false;
    }

    @Override
    public User findByName(String name) throws DAOException {
        if (name == "Rakhat") {
            return new User(1,"12","sdf", "wed", "dsfr", 1);
        }
        return null;
    }

    public boolean alreadyExist(String login){
        try(PreparedStatement preparedStatement = connection.prepareStatement("select users.login from users where" +
                "login ="+"'"+login+"'")) {
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                LOGGER.info("User already exists - "+login);
                return resultSet.next();
            }
        } catch (Exception e) {
            throw new DAOException(e);
        }
    }

    @Override
    public int insert(User user) {
        return 0;
    }

    public boolean checkCredentials(User user, String password) {
        return user != null && user.getPassword().equals(password);
    }

    public boolean deleteUser(int id) throws SQLException {
         return false;
    }

    public List returnAllUsers (){
        return null;
    }
}
