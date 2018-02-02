package com.epam.rakhat.Service;

import com.epam.rakhat.Dao.DaoManager.DaoManager;
import com.epam.rakhat.Dao.PostgresImpl.DaoFactory;
import com.epam.rakhat.Dao.PostgresImpl.UserDaoImpl;
import com.epam.rakhat.Entities.User;
import com.epam.rakhat.Exceptions.DAOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

import static com.epam.rakhat.Constants.Constants.*;

public class ServiceLogin {
    private static final Logger LOGGER = Logger.getLogger(ServiceLogin.class.getName());

    public String returnRole (HttpServletRequest request){
        HttpSession session = request.getSession();
        DaoManager daoManager = DaoFactory.getInstance().getDaoManager();
        UserDaoImpl userDaoImpl = daoManager.getUserDaoImpl();
//        try{
//            User user = userDaoImpl.findByLogin(request.getParameter(LOGIN));
//        }
    return null;}


    public boolean isLoginExists (String login){
        DaoManager daoManager = DaoFactory.getInstance().getDaoManager();
        UserDaoImpl userDaoImpl = daoManager.getUserDaoImpl();
        try{
         return userDaoImpl.findByLogin(login);
        } catch (Exception e){
            throw new DAOException(e);
        }
    }
}
