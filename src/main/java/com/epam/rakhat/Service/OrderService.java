package com.epam.rakhat.Service;

import com.epam.rakhat.Dao.DaoManager.DaoManager;
import com.epam.rakhat.Dao.OrderDao;
import com.epam.rakhat.Dao.PostgresImpl.DaoFactory;
import com.epam.rakhat.Entities.Order;
import com.epam.rakhat.Entities.User;
import com.epam.rakhat.Util.Validator;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

import static com.epam.rakhat.Constants.Constants.*;

public class OrderService {

    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(OrderService.
            class.getName());

    public String createAnOrder(HttpServletRequest request) {
        DaoManager daoManager = DaoFactory.getInstance().getDaoManager();
        OrderDao orderDao = daoManager.getOrderDaoImpl();
        Validator validator = validateFieldsOrder(request);
        if (validator.isValide()) {
            Order order = getOrderFromRequest(request);
            User user = getUserFromRequest(request);
            daoManager.startTransaction();
            try {
                orderDao.insertOrder(order.getOrderId(), order.getOrderDate(), user.getID(),
                        order.getDateCreated(), order.getDateFinished(), order.getStatus());
                daoManager.commit();
            } catch (SQLException e) {
                daoManager.rollback();
                LOGGER.error("can not create an order", e);
                return ERROR;
            } finally {
                DaoFactory.getInstance().putBackConnection(daoManager.returnConnection());
            }
        } else {
            return ADDRESS_IS_INCORRECT;
        }
        return ORDER_CREATED_PAGE;
        }

        private Validator validateFieldsOrder(HttpServletRequest request){
        Validator validator = new Validator();
        validator.checkOrderDate(request.getParameter(ORDER_DATE));
        return validator;
        }

        public String cancelAnOrder (HttpServletRequest request){

        DaoManager daoManager = DaoFactory.getInstance().getDaoManager();
        OrderDao orderDao = daoManager.getOrderDaoImpl();
        daoManager.startTransaction();
        try{
            orderDao.cancelTheOrders(getUserFromRequest(request).getID());
            daoManager.commit();
        } catch (SQLException e){
            daoManager.rollback();
            LOGGER.error("can not create an order", e);
            return ERROR;
        } finally {
            DaoFactory.getInstance().putBackConnection(daoManager.returnConnection());
        }
        return ORDERS_WERE_CANCELLED;
        }

        public String acceptAnOrder(HttpServletRequest request){

        DaoManager daoManager = DaoFactory.getInstance().getDaoManager();
        OrderDao orderDao = daoManager.getOrderDaoImpl();
        int idOrder = Integer.parseInt(request.getParameter(ACCEPT_AN_ORDER));
        daoManager.startTransaction();
        try{
            orderDao.acceptAnOrder(idOrder);
            daoManager.commit();
        } catch (SQLException e){
            daoManager.rollback();
            LOGGER.error("can not accept an order", e);
            return ERROR;
        } finally {
            DaoFactory.getInstance().putBackConnection(daoManager.returnConnection());
        }
        return ORDER_ACCEPTED_PAGE;
        }

        public String rejectAnOrder (HttpServletRequest request){

        DaoManager daoManager = DaoFactory.getInstance().getDaoManager();
        OrderDao orderDao = daoManager.getOrderDaoImpl();
        int idOrder = Integer.parseInt(request.getParameter(REJECT_AN_ORDER));
        daoManager.startTransaction();
        try{
            orderDao.rejectAnOrder(idOrder);
            daoManager.commit();
        } catch (SQLException e) {
            daoManager.rollback();
            LOGGER.error("an order has been rejected", e);
          return ERROR;
        } finally {
            DaoFactory.getInstance().putBackConnection(daoManager.returnConnection());
        }
        return ORDER_REJECTTED_PAGE;
        }

        private User getUserFromRequest(HttpServletRequest request){
        User user = new User();
        user.setID(((User) request.getSession().getAttribute(USER)).getID());
            return user;
        }

        private Order getOrderFromRequest(HttpServletRequest request){
        Order order = new Order();
        order.setOrderId(request.getParameter(ORDER_ID));
        order.setDateCreated(request.getParameter(DATE_CREATED));
        order.setDateCreated(request.getParameter(DATE_FINISHED));
        order.setStatus(request.getParameter(STATUS_NAME));
        return order;
        }
}
