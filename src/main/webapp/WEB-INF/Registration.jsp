<%--
  Created by IntelliJ IDEA.
  User: Rakhat
  Date: 02.02.2018
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<fmt:setLocale value="${locale}"/>

<fmt:bundle basename="i18n.messages">
    <fmt:message key="message.login" var="login"/>
    <fmt:message key="message.password" var="password"/>
    <fmt:message key="message.phone.number" var="phone number"/>
    <fmt:message key="message.registration" var="registration"/>
    <fmt:message key="message.welcome.back" var="backToWelcome"/>
    <fmt:message key="message.email" var="email"/>
    <fmt:message key="message.order.id" var="orderId"/>
    <fmt:message key="navigation.rus" var="navigationRU"/>
    <fmt:message key="navigation.eng" var="navigationENG"/>
</fmt:bundle>
<html>
<head>
<t:gHead>
    <title>Registration</title>
</t:gHead>
</head>
<body>
    <form action="/Controller/changeLocale" method="post">
        <select onchange="submit()" name="locale">
            <option
                    <c:if test="${locale == 'ru'}">selected</c:if> value="ru">
                ${navigationRU}
            </option>

            <option
                    <c:if test="${locale == 'en'}">selected</c:if> value="en">
                ${navigationENG}
            </option>
        </select>
    </form>
    <form action="/Controller/doRegistration" method="post">
        ${login}<br/>
        <input type="text" name="login" value=""/><br/>
        ${password}<br/>
        <input type="password" name="password" value=""/><br/>
        ${phone_number}<br/>
        <input type="text" name="phone number" value=""/><br/>
        ${email}<br/>
        <input type="email" name="email" value=""/><br/>
        <input type="submit" id="registration" name="doRegistration" value="${registration}"/><br/>
    </form>
    <t:invalidFields invalidFields="${invalidFields}">

    </t:invalidFields>
    <a href="/Controller/welcome">${backToWelcome}</a>

</body>
</html>
