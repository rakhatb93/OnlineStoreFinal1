package com.epam.rakhat.Dao;

import com.epam.rakhat.Entities.ItemOrderDetail;
import com.epam.rakhat.Exceptions.DAOException;

public interface Item_Order_DetailsDao extends CommonDao<ItemOrderDetail> {
     ItemOrderDetail findByCost(int cost) throws DAOException;
}
