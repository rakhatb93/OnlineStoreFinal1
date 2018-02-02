<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fmt:setLocale value="${locale}"/>
<fmt:bundle basename="i18n.messages">
    <!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
My project is a simple online store. The website consists of two languages and those are Russian and English. Also,
    there is an admin, user and a manager. User is able to register himself and perform orders. Manager  can accept and
    reject orders. And admin is capable of removing users.

    <p><a href="/Controller/registration"><fmt:message
        key="message.registration"/></a></p>
    <p><a href="/Controller/login"><fmt:message
        key="message.login"/></a></p>
    <form action="/Controller/changeLocale" method="post">

    <select onchange="submit()" name="locale">
    <option
    <c:if test="${locale == 'ru'}">selected</c:if> value="ru">
    <fmt:message key="navigation.rus"/>
    </option>
    <option
    <c:if test="${locale == 'en'}">selected</c:if> value="en">
    <fmt:message key="navigation.eng"/>
    </option>
    </select>
    </form>
    </body>
</html>
</fmt:bundle>