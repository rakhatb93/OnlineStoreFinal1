package com.epam.rakhat.Action.Show;

import com.epam.rakhat.Action.Action;
import com.epam.rakhat.Action.ActionResult;
import com.epam.rakhat.Service.UserService;

import javax.servlet.http.HttpServletRequest;

import static com.epam.rakhat.Constants.Constants.*;

public class ManagerPage implements Action {

    private UserService userService = new UserService();

    @Override
    public ActionResult execute(HttpServletRequest request) {
        String result = userService.managerPage(request);
        if(request.equals(ERROR)) return new ActionResult(ERROR, true);

        return new ActionResult(result);
    }
}
