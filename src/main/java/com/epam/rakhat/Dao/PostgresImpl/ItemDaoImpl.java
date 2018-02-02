package com.epam.rakhat.Dao.PostgresImpl;

import com.epam.rakhat.Dao.ItemDao;
import com.epam.rakhat.Entities.Item;
import com.epam.rakhat.Exceptions.DAOException;

import java.sql.Connection;

public class ItemDaoImpl extends BaseDao<Item> implements ItemDao {

    private Connection connection;

    public ItemDaoImpl(Connection connection){
        super(connection);
        this.connection = connection;
    }

    @Override
    public Item findByItem_id(int item_id) throws DAOException {
        return null;
    }
}
