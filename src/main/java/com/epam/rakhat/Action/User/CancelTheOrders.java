package com.epam.rakhat.Action.User;

import com.epam.rakhat.Action.Action;
import com.epam.rakhat.Action.ActionResult;
import com.epam.rakhat.Service.OrderService;

import javax.servlet.http.HttpServletRequest;

public class CancelTheOrders implements Action {

    private OrderService orderService = new OrderService();
    private ActionResult actionResult = new ActionResult();

    public ActionResult execute (HttpServletRequest request){

        String resultFromService = orderService.cancelAnOrder(request);
        boolean redirect = actionResult.redirectionResult(resultFromService);
        return new ActionResult(resultFromService, redirect);
    }
}
