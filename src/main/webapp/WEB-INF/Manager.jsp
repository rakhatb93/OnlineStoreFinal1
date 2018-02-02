<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 01.02.2018
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<fmt:setLocale value="${locale}"/>
<fmt:bundle basename="i18n.messages">
    <fmt:message key="message.accept" var="accept"/>
    <fmt:message key="message.welcome.back" var="welcomeBack"/>
    <fmt:message key="message.reject" var="reject"/>
    <fmt:message key="message.order.id" var="orderId"/>
    <fmt:message key="message.user.id" var="userId"/>
    <fmt:message key="message.country" var="country"/>
    <fmt:message key="message.city" var="city"/>
    <fmt:message key="message.street" var="street"/>
    <fmt:message key="message.phone.number" var="phoneNumber"/>
    <fmt:message key="message.back.to.manager.page" var="backToManager"/>
    <fmt:message key="navigation.rus" var="navigationRU"/>
    <fmt:message key="navigation.eng" var="navigationENG"/>
</fmt:bundle>
<html>
<head>
    <t:gHead>
    <title>Manager</title>
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
<table border="1" cellpadding="7" cellspacing="0">
    <tr>
    <td colspan="2" bgcolor="#deb887" align="center">
    <c:forEach var="entities" items="${orders}">
        <form action="/Controller/acceptAnOrder" method="post">
        <p><input type="hidden" name="acceptAnOrder" value="${entities.getID()}">
        <input type="submit" value="${accept}">
        </p></form>
        <form action="/Controller/rejectAnOrder" method="post">
        <p><input type="hidden" name="rejectAnOrder" value="${entities.getID()}">
        <input type="submit" value="${reject}">
        </p></form>
        <div>
        ${order_id}
        ${entities.getOrder_id()}
        </div>
        <div>
        ${order_date}
        ${entities.getOrder_date()}
        </div>
        <div>
        ${user_id}
        ${entities.getUser_id()}
        </div>
        <div>
        ${date_created}
        ${entities.getDate_created()}
        </div>
        <div>
        ${date_finished}
        ${entities.getDate_finished()}
        </div>
        <div>
        ${status}
        ${entities.setStatus()}
        </div>
    </c:forEach></td></tr>
</table>
<p><a href="/Controller/welcome">${welcomeBack}</a></p>
<p><a href="/Controller/manager">${backToManager}</a></p>
</body>
</html>
