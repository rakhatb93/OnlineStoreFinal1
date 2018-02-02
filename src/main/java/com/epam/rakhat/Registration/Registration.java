package com.epam.rakhat.Registration;

import com.epam.rakhat.Action.Action;
import com.epam.rakhat.Action.ActionResult;
import com.epam.rakhat.Service.RegistrationService;

import javax.servlet.http.HttpServletRequest;

public class Registration implements Action{

    private RegistrationService registrationService = new RegistrationService();
    private ActionResult actionResult = new ActionResult();

    @Override
    public ActionResult execute(HttpServletRequest request) {

        String resultFromAction = registrationService.tryToRegister(request);
        boolean redirect = actionResult.redirectionResult(resultFromAction);
        return new ActionResult(resultFromAction, redirect);
    }
}
