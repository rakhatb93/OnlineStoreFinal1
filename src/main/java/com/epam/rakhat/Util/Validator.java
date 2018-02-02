package com.epam.rakhat.Util;

import com.epam.rakhat.Dao.DaoManager.DaoManager;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private final String USER_NAME_FIRST_CHARACTER_NOT_A_DIGIT = "^[a-zA-Z][a-zA-Z0-9-_\\.]{1,}$";
    private final String USER_NAME_LENGTH_LESS_THAN_15_CHARACTERS = "(.){0,15}$";
    private final String USER_NAME_LENGTH_MORE_THAN_6_CHARACTERS = "^(.){6,}";
    private final String USER_NAME_NOT_ALLOWED_SYMBOLS = "^[a-zA-Z0-9-_\\.]{0,}$";

    private final String USER_PASSWORD_REQUIRES_A_DIGIT = "^(?=.*\\d).*$";
    private final String USER_PASSWOED_REQUIRES_AN_UPPERCASE = "^(?=.*[A-Z]).*$";
    private final String USER_PASSWORD_REQUIRES_A_LOWERCASE = "^(?=.*[a-z]).*$";
    private final String USER_PASSWORD_NOT_ALLOWED_SYMBOLS = "[a-zA-Z0-9]{0,}$";
    private final String USER_PASSWORD_NOT_LESS_THAN_6_CHARACTERS = "^(.){6,}$";
    private final String USER_PASSWORD_NO_MORE_THAN_15_CHARACTERS = "^(.){0,15}$";

    private final String USER_NAME_MORE_THAN_20_CHARACTERS = "(.){0,20}$";
    private final String ADDRESS = "^[a-zA-Z][a-zA-Z0-9-_\\.\\ ]{1,19}$";
    private final String EMAIL = "^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$";
    private final String PHONE_NUMBER = "^(8|\\+7)\\d{10}$";

    private Map<String, String> results = new HashMap<>();
    private Map<String, String> invalidFields = new HashMap<>();
    private static Map<String, String> loginValidFields = new HashMap<>();
    private static Map<String, String> passwoedValidFields = new HashMap<>();
    private Matcher matcher;
    private DaoManager daoManager;

    public Validator(DaoManager daoManager) {
        this.daoManager = daoManager;
    }

    public Validator() {
    }

    public Map<String, String> getInvalidFields() {
        return invalidFields;
    }

    public void initValidationFields() {

        loginValidFields.put(USER_NAME_FIRST_CHARACTER_NOT_A_DIGIT, "login.first.is.a.digit");
        loginValidFields.put(USER_NAME_LENGTH_LESS_THAN_15_CHARACTERS, "login.less.than.15.characters");
        loginValidFields.put(USER_NAME_LENGTH_MORE_THAN_6_CHARACTERS, "login.more.than.6.characters");
        loginValidFields.put(USER_NAME_NOT_ALLOWED_SYMBOLS, "login.not.allowed.characters");

        loginValidFields.put(USER_PASSWORD_REQUIRES_A_DIGIT, "password.requires.a.digit");
        loginValidFields.put(USER_PASSWOED_REQUIRES_AN_UPPERCASE, "password.requires.an.uppercase");
        loginValidFields.put(USER_PASSWORD_REQUIRES_A_LOWERCASE, "password.requires.a.lowercase");
        loginValidFields.put(USER_PASSWORD_NOT_ALLOWED_SYMBOLS, "password.not.allowed.symbols");
        loginValidFields.put(USER_PASSWORD_NOT_LESS_THAN_6_CHARACTERS, "password.not.less.than.6.characters");
        loginValidFields.put(USER_PASSWORD_NO_MORE_THAN_15_CHARACTERS, "password.no.more.than.15.characters");
    }

    public boolean isValide() {
        for (Map.Entry<String, String> stringEntry : results.entrySet()) {
            if (stringEntry.getValue().equals("false")) {
                invalidFields.put(stringEntry.getKey().substring(0, stringEntry.getKey().indexOf(".")),
                        stringEntry.getKey());
            }
        }
        if (invalidFields.isEmpty()) return true;
        else return false;
    }

    public void checkLogin(String login) {
        if (login == null || login.equals(" ")) {
            results.put("login.is.required.field", "false");
        } else {
            if (daoManager.getUserDaoImpl().alreadyExist(login)) {
                results.put("login is not available", "false");
            } else {
                for (String key : loginValidFields.keySet()) {
                    matcher = Pattern.compile(key).matcher(login);
                    if (!matcher.matches()) {
                        results.put(loginValidFields.get(key), "false");
                    }
                }
            }
        }
    }

    public void checkUserPassword(String password) {
        if (password == null || password.equals(" ")) {
            results.put("password.is.required.field", "false");
        } else {
            for (String key : passwoedValidFields.keySet()) {
                matcher = Pattern.compile(key).matcher(password);
                if (!matcher.matches()) {
                    results.put(passwoedValidFields.get(key), "false");
                }
            }
        }
    }

    public void checkUserPhone(String phone_number) {
        if (phone_number == null || phone_number.equals(" ")) {
            results.put("phone.required.field", "false");
        } else {
            matcher = Pattern.compile(PHONE_NUMBER).matcher(phone_number);
            if (!matcher.matches()) results.put("phone.number.is.incorrect", "false");
        }
    }

    public void checkEmail(String email) {
        if (email == null || email.equals("")) {
            results.put("email.is.required.field", "false");
        } else {
            matcher = Pattern.compile(EMAIL).matcher(email);
            if (!matcher.matches()) results.put("email.is.incorrect", "false");
        }
    }

    public void checkAddress(String address) {
        if (address == null || address.equals(" ")) {
            results.put("address.is.required", "false");
        } else {
            matcher = Pattern.compile(USER_NAME_MORE_THAN_20_CHARACTERS).matcher(address);
            if (!matcher.matches()) results.put("address.more.than.15", "false");
        }
    }

    public void checkOrderDate(String order_date){
        if(order_date == null || order_date.equals(" ")){
            results.put("address.is.required.field", "false");
        } else {
            matcher = Pattern.compile(USER_NAME_MORE_THAN_20_CHARACTERS).matcher(order_date);
        } if (!matcher.matches()) results.put("order_date.more.than.20", "false");
    }
}