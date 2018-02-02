package com.epam.rakhat.Service;

import com.epam.rakhat.Dao.DaoManager.DaoManager;
import com.epam.rakhat.Dao.PostgresImpl.DaoFactory;
import com.epam.rakhat.Dao.PostgresImpl.UserDaoImpl;
import com.epam.rakhat.Entities.User;
import com.epam.rakhat.Util.Validator;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.epam.rakhat.Constants.Constants.*;

public class RegistrationService {
    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(RegistrationService.class.
            getName());
    private Validator validator;

    public String tryToRegister(HttpServletRequest request){
        DaoManager daoManager = DaoFactory.getInstance().getDaoManager();
        UserDaoImpl userDaoImpl = daoManager.getUserDaoImpl();
        this.validator = new Validator(daoManager);
        if (validateFieldsOfUser(request)){
            User user = createUser(request);
            daoManager.startTransaction();
            try{
                userDaoImpl.insert(user);
                daoManager.commit();
            } catch (Exception e){
                daoManager.rollback();
                LOGGER.error("User creation has failed", e);
                return ERROR;
            } finally {
                DaoFactory.getInstance().putBackConnection(daoManager.returnConnection());
            }
            LOGGER.info("User has been registered " + user);
            request.setAttribute("youHaveSuccesfullyRegistered", "You have succesfully registered!");
            return REGISTRATION;
        } else {
            LOGGER.info("User creation has been failed");
            return REGISTRATION;
        }
    }

    private User createUser(HttpServletRequest request){
        User user = new User();
        user.setLogin(request.getParameter(LOGIN));
        user.setPassword(request.getParameter(PASSWORD));
        user.setEmail(request.getParameter(EMAIL));
        user.setPhoneNumber(request.getParameter(PHONE_NUMBER));
        return user;
        }

        private boolean validateFieldsOfUser(HttpServletRequest request) {
            validator.checkLogin(request.getParameter(LOGIN));
            validator.checkUserPassword(request.getParameter(PASSWORD));
            validator.checkEmail(request.getParameter(EMAIL));
            validator.checkUserPhone(request.getParameter(PHONE_NUMBER));
            if (validator.isValide()) {
                return true;
            } else {
                Map<String, String> invalidFields = validator.getInvalidFields();
                RegistrationService.CustomMap<String, String > customMap = new RegistrationService.
                        CustomMap<>(invalidFields);
                request.setAttribute(INVALID_FIELDS, customMap.getValues());
                return false;
            }
        }

        private class CustomMap<K, V> {
        Map<K, V> someMap = new HashMap<>();

        private CustomMap(Map<K, V> map) {
            this.someMap = map;
        }

        private ArrayList<V> getValues(){
            return new ArrayList<>(someMap.values());
            }
        }
}
