package com.epam.rakhat.Dao;

import com.epam.rakhat.Entities.Item;
import com.epam.rakhat.Exceptions.DAOException;

public interface ItemDao extends CommonDao<Item>{
    Item findByItem_id(int idem_id) throws DAOException;
}
