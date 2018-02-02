package com.epam.rakhat.Dao.PostgresImpl;

import com.epam.rakhat.Dao.OrderDao;
import com.epam.rakhat.Entities.ItemOrderDetail;
import com.epam.rakhat.Entities.Order;
import com.epam.rakhat.Entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.epam.rakhat.Constants.Constants.*;

public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {

    private Connection connection;

    public OrderDaoImpl(Connection connection) {
        super(connection);
        this.connection = connection;
    }

    public Order findByDate(String order_date) {
        return null;
    }

    @Override
    public int insertOrder(String order_id, String order_date, int user_id, String date_created, String date_finished, String status) throws SQLException {
        return 0;
    }

    @Override
    public boolean acceptAnOrder(int order_id) throws SQLException {
        return false;
    }

    @Override
    public boolean rejectAnOrder(int order_id) throws SQLException {
        return false;
    }

    @Override
    public boolean cancelTheOrders(int id) throws SQLException {
        return false;
    }

    public List<Order> returnAwaitingOrders() throws SQLException {
        List<Order> orders = new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users inner join " +
                    "orders on users.id = orders inner join" + "status on order = status.id where status.id = " +
                    ORDER_STATUS_WAITING_INT);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Order order = new Order();
            ItemOrderDetail itemOrderDetail = new ItemOrderDetail();
            User user = new User();
            user.setPhoneNumber(resultSet.getString(PHONE_NUMBER));
            order.setStatus(resultSet.getString(STATUS_NAME));
            itemOrderDetail.setId(resultSet.getInt(16));
            itemOrderDetail.setCount(7);
            order.setDateCreated(DATE_CREATED);
            orders.add(order);
        }
        return orders;
        }
    }

