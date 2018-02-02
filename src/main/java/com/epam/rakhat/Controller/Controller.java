package com.epam.rakhat.Controller;
import com.epam.rakhat.Action.Action;
import com.epam.rakhat.Action.ActionException;
import com.epam.rakhat.Action.ActionFactory;
import com.epam.rakhat.Action.ActionResult;
import com.epam.rakhat.Util.Validator;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet{

    private static final org.apache.log4j.Logger LOGGER = Logger.getLogger(Controller.class.getName());
    private ActionResult actionResult = new ActionResult();
    private Validator validator = new Validator();

    public void init() throws ServletException{
        actionResult.initRedirectionFields();
        validator.initValidationFields();
        super.init();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        Action action = ActionFactory.getAction(request);
        ActionResult result = null;
        if(action!=null){
            try{
                result = action.execute(request);
            } catch (ActionException e){
                LOGGER.error("error in controller", e);
                throw new ActionException(e);
            }
            if(result.isRedirection()){
                response.sendRedirect(request.getContextPath()+"/Controller/"+result.getView());
                return;
            }
            request.getRequestDispatcher("/WEB-INF/"+result.getView()+".jsp").forward(request, response);
        }
    }
}
