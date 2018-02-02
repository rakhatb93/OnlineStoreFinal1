package com.epam.rakhat.Action.Manager;

import com.epam.rakhat.Action.Action;
import com.epam.rakhat.Action.ActionResult;
import com.epam.rakhat.Entities.Order;
import com.epam.rakhat.Service.OrderService;

import javax.servlet.http.HttpServletRequest;

public class RejectAnOrder implements Action{

    OrderService orderService = new OrderService();
    ActionResult actionResult =new ActionResult();

    @Override
    public ActionResult execute(HttpServletRequest request) {

        String resultFromAction = orderService.rejectAnOrder(request);
        boolean redirect = actionResult.redirectionResult(resultFromAction);
        return new ActionResult(resultFromAction, redirect);
    }
}
