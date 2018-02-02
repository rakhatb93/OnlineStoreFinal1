package com.epam.rakhat.Action.Show;

import com.epam.rakhat.Action.Action;
import com.epam.rakhat.Action.ActionException;
import com.epam.rakhat.Action.ActionResult;

import javax.servlet.http.HttpServletRequest;

import static com.epam.rakhat.Constants.Constants.*;

public class ErrorPage implements Action{

    @Override
    public ActionResult execute(HttpServletRequest request) throws ActionException{
        return new ActionResult(ERROR);
    }
}
