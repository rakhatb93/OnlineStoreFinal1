package com.epam.rakhat.Action;

import javax.servlet.http.HttpServletRequest;

public interface Action {
    ActionResult execute(HttpServletRequest request);
}
