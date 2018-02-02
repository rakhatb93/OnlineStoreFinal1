package com.epam.rakhat.Dao.DaoManager;

import com.epam.rakhat.Dao.PostgresImpl.*;
import com.epam.rakhat.Exceptions.DAOException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DaoManager {
    private static final Logger LOGGER = Logger.getLogger(DaoManager.class.getName());
    private final Connection connection;

    public DaoManager (Connection connection){
        this.connection = connection;
    }

    public void startTransaction() throws DAOException{
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public void commit()throws DAOException{
        try {
            connection.commit();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public void rollback(){
        try {
            connection.rollback();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public Connection returnConnection(){
        return connection;
    }

    public AddressDaoImpl getAddresDaoImpl(){
        return new AddressDaoImpl(connection);
    }

    public Item_Order_DetailsDaoImpl getItem_Order_Details(){
        return new Item_Order_DetailsDaoImpl(connection);
    }

    public ItemDaoImpl getItwmDaoImpl(){
        return new ItemDaoImpl(connection);
    }

    public OrderDaoImpl getOrderDaoImpl(){
        return new OrderDaoImpl(connection);
    }

    public  UserDaoImpl getUserDaoImpl(){
        return new UserDaoImpl(connection);
    }

    public CharacteristicsDaoImpl getCharacteristicsDaoImpl(){
        return new CharacteristicsDaoImpl(connection);
    }

    public void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
