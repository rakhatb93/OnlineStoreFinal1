package com.epam.rakhat.Dao;

import com.epam.rakhat.Entities.Order;
import com.epam.rakhat.Exceptions.DAOException;

import java.sql.SQLException;

public interface OrderDao extends CommonDao<Order> {
    Order findByDate(String order_date) throws DAOException;
    int insertOrder(String order_id, String order_date, int user_id, String date_created, String date_finished,
                    String status) throws SQLException;
    boolean acceptAnOrder (int order_id) throws SQLException;
    boolean rejectAnOrder(int order_id) throws SQLException;
    boolean cancelTheOrders(int id) throws SQLException;
}
