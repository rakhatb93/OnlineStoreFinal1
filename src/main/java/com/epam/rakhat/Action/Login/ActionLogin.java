package com.epam.rakhat.Action.Login;

import com.epam.rakhat.Action.Action;
import com.epam.rakhat.Action.ActionResult;
import com.epam.rakhat.Service.ServiceLogin;

import javax.servlet.http.HttpServletRequest;

public class ActionLogin implements Action{

    private ServiceLogin serviceLogin = new ServiceLogin();
    private ActionResult actionResult = new ActionResult();

    @Override
    public ActionResult execute(HttpServletRequest request) {

//        String resultFromService = serviceLogin
//        boolean resultFromService = serviceLogin.isLoginExists();
     return null;}
}