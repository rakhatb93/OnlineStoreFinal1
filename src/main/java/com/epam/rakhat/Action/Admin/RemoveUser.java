package com.epam.rakhat.Action.Admin;

import com.epam.rakhat.Service.UserService;
import com.epam.rakhat.Action.Action;
import com.epam.rakhat.Action.ActionResult;

import javax.servlet.http.HttpServletRequest;

public class RemoveUser implements Action{

    private ActionResult actionResult = new ActionResult();
    private UserService userService = new UserService();

    @Override
    public ActionResult execute(HttpServletRequest request) {

        String serviceResult = userService.deleteUser(request);
        boolean redirect = actionResult.redirectionResult(serviceResult);
        return new ActionResult(serviceResult, redirect);
    }
}
