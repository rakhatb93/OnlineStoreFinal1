<%--
  Created by IntelliJ IDEA.
  User: Rakhat
  Date: 02.02.2018
  Time: 15:38
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
    <title>RegistrationManager</title>
</head>
<body>
<form action="/Controller/doRegistration" method="post">
    ${login}<br/>
    <input type="text" name="login" value=""/><br/>
    ${password}<br/>
    <input type="password" name="password" value=""/><br/>
    ${email}<br/>
    <input type="email" name="email" value=""/><br/>
    ${phone_number}<br/>
    <input type="text" name="phone_number" value=""/><br/>
    <input type="submit" id="registration" name="doRegistration" value="${registration}"/><br/>
</form>
<t:invalidFields invalidFields="${invalidFields}">

</t:invalidFields>
</body>
</html>
