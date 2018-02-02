package com.epam.rakhat.Action;


import com.epam.rakhat.Action.Admin.RemoveUser;
import com.epam.rakhat.Action.Login.ActionLogin;
import com.epam.rakhat.Action.Manager.AcceptAnOrder;
import com.epam.rakhat.Action.Manager.RejectAnOrder;
import com.epam.rakhat.Action.Registration.DoRegistration;
import com.epam.rakhat.Action.Show.*;
import com.epam.rakhat.Action.User.CancelTheOrders;
import com.epam.rakhat.Action.User.PerformAnOrder;
import com.epam.rakhat.Constants.Constants;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ActionFactory extends Constants {

    public static Map<String, Action> actionMap = new HashMap<>();

    static {
        actionMap.put(WELCOME, new Welcome());
        actionMap.put(REGISTRATION, new com.epam.rakhat.Action.Show.Registration());
        actionMap.put(DO_REGISTRATION, new DoRegistration());
        actionMap.put(ACTION_LOGIN, new ActionLogin());
        actionMap.put(LOGIN, new LoginPage());
        actionMap.put(ERROR, new ErrorPage());
        actionMap.put(ADMIN_PAGE, new AdminPage());
        actionMap.put(MANAGER_PAGE, new ManagerPage());
        actionMap.put(USER_PAGE, new UserPage());
        actionMap.put(PERFORM_AN_ORDER, new PerformAnOrder());
        actionMap.put(CANCEL_THE_ORDERS,new CancelTheOrders());
        actionMap.put(ACCEPT_AN_ORDER, new AcceptAnOrder());
        actionMap.put(REJECT_AN_ORDER, new RejectAnOrder());
        actionMap.put(REMOVE_USER, new RemoveUser());
        actionMap.put(CHANGE_LOCALE, new LocaleChange());
    }

    public static Action getAction(HttpServletRequest request){
        return actionMap.get(request.getPathInfo().substring(1));
    }
}
