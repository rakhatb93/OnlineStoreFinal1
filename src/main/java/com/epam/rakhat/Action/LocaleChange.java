package com.epam.rakhat.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;

//import static com.sun.org.apache.xerces.internal.impl.dtd.XMLDTDLoader.LOCALE;

public class LocaleChange implements Action{

    public ActionResult execute (HttpServletRequest request){
//       String page = request.getHeader("referer");
//        page = page.substring(page.indexOf("/Controller/")+12);
//
//        ActionResult currentPage = new ActionResult(page, true);
//        String locale = request.getParameter(LOCALE);
//        HttpSession session = request.getSession();
//        session.setAttribute(LOCALE, new Locale(locale));
//        return currentPage;
    return null;}
}
