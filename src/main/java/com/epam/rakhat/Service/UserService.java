package com.epam.rakhat.Service;

import com.epam.rakhat.Dao.DaoManager.DaoManager;
import com.epam.rakhat.Dao.PostgresImpl.DaoFactory;
import com.epam.rakhat.Dao.PostgresImpl.OrderDaoImpl;
import com.epam.rakhat.Dao.PostgresImpl.UserDaoImpl;
import com.epam.rakhat.Entities.Order;
import com.epam.rakhat.Entities.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import static com.epam.rakhat.Constants.Constants.*;

public class UserService {

    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(UserService.class.getName());

    public String deleteUser (HttpServletRequest request){
        DaoManager daoManager = DaoFactory.getInstance().getDaoManager();
        UserDaoImpl userDaoImpl = daoManager.getUserDaoImpl();
        try {
            daoManager.startTransaction();
            User user = getUserFromRequest(request);
            userDaoImpl.deleteUser(user.getID());
            daoManager.commit();
        } catch (SQLException e){
            daoManager.rollback();
            LOGGER.error("user can not be removed", e);
            return ERROR;
        } finally {
            DaoFactory.getInstance().putBackConnection(daoManager.returnConnection());
        }
        return USER_IS_REMOVED_PAGE;
    }

    public User getUserFromRequest(HttpServletRequest request){
        User user = new User();
        user.setID(((User) request.getSession().getAttribute(USER)).getID());
        return user;
    }

    public String adminPage (HttpServletRequest request){
        DaoManager daoManager = DaoFactory.getInstance().getDaoManager();
        try {
            UserDaoImpl userDaoImpl = daoManager.getUserDaoImpl();
            List users = userDaoImpl.returnAllUsers();
            if (users!=null){
                request.setAttribute(USERS, users);
            }
        } catch (Exception e){
            e.printStackTrace();
            LOGGER.error("can not show users", e);
            return ERROR;
        } finally {
            DaoFactory.getInstance().putBackConnection(daoManager.returnConnection());
        }
        return ADMIN_PAGE;
    }

    public String managerPage(HttpServletRequest request){
        DaoManager daoManager = DaoFactory.getInstance().getDaoManager();
        OrderDaoImpl orderDaoImpl = daoManager.getOrderDaoImpl();
        List<Order> orderList;
        try{
            orderList = orderDaoImpl.returnAwaitingOrders();
        } catch (Exception e){
            e.printStackTrace();
            LOGGER.error("can not get orders", e);
            return ERROR;
        } finally {
            DaoFactory.getInstance().putBackConnection(daoManager.returnConnection());
        }
        request.setAttribute(ORDERS, orderList);
        return MANAGER;
    }

}
