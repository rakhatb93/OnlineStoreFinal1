<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 01.02.2018
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<fmt:setLocale value="${locale}"/>
<fmt:bundle basename="i18n.messages">
    <fmt:message key="message.welcome.back" var="welcomeBack"/>
    <fmt:message key="message.street" var="street"/>
    <fmt:message key="message.zip.code" var="zipCode"/>
    <fmt:message key="message.country" var="country"/>
    <fmt:message key="message.welcome.back" var="welcomeBack"/>
    <fmt:message key="message.city" var="city"/>
    <fmt:message key="message.perform.an.order" var="performAnOrder"/>
    <fmt:message key="message.welcome.back" var="welcomeBack"/>
    <fmt:message key="message.back.to.user.page" var="backToUser"/>
    <fmt:message key="button.cancel.all" var="cancelAll"/>
    <fmt:message key="message.sort.of.pay" var="sortOfPay"/>
    <fmt:message key="message.orders.were.cancelled" var="ordersWereCancelled"/>
    <fmt:message key="navigation.rus" var="navigationRu"/>
    <fmt:message key="navigation.eng" var="navigationENG"/>
</fmt:bundle>
<html>
<head>
    <t:gHead>
    <title>User</title>
    </t:gHead>
</head>
<body>
${sortOfPay} = 5.75$
<form action="/Controller/performAnOrder" method="post">
    <p><input placeholder="${country}" name="country"></p>
    <p><input placeholder="${city}" name="city"></p>
    <p><input placeholder="${street}" name="street"></p>
    <input type="submit" name="performAnOrder" value="${performAnOrder}">
</form>
<form action="/Controller/cancelAll">
    <input type="submit" name="cancelAll" value="${cancelAll}">
</form>
</form>
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
<p><a href="/Controller/welcome">${welcomeBack}</p>
</body>
</html>
