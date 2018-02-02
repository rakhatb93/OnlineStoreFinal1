package com.epam.rakhat.Dao.PostgresImpl;

import com.epam.rakhat.Dao.Item_Order_DetailsDao;
import com.epam.rakhat.Entities.ItemOrderDetail;
import com.epam.rakhat.Exceptions.DAOException;

import java.sql.Connection;

public class Item_Order_DetailsDaoImpl extends BaseDao<ItemOrderDetail> implements Item_Order_DetailsDao {

    private Connection connection;
    public Item_Order_DetailsDaoImpl(Connection connection){
       super(connection);
       this.connection = connection;
    }
    @Override
    public ItemOrderDetail findByCost(int cost) throws DAOException{
        return null;
    }
}
