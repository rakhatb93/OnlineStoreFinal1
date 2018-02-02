package com.epam.rakhat.Action;

import java.util.ArrayList;

import static com.epam.rakhat.Constants.Constants.*;



public class ActionResult {
    private String view;
    private boolean redirection;
    private static final ArrayList<String> pagesRedirection = new ArrayList<>();

    public void initRedirectionFields(){
        pagesRedirection.add(ERROR);
        pagesRedirection.add(ADMIN);
        pagesRedirection.add(GUEST);
        pagesRedirection.add(USER);
    }

    public ActionResult(){

    }

    public ActionResult(String view){
       this.view = view;
    }

    public ActionResult(String view, boolean redirection){
        this.view = view;
        this.redirection = redirection;
    }

    public String getView(){
        return view;
    }

    public void setView(String view){
        this.view = view;
    }

    public boolean isRedirection(){
        return redirection;
    }

    public void setRiderection(boolean redirection){
        this.redirection = redirection;
    }

    public boolean redirectionResult(String page){
        return pagesRedirection.contains(page);
    }
}
