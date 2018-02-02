<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<fmt: setLocale value = "${locale}"/>
<fmt:bundle basename="i18n.messages">
    <fmt:message key="message.welcome.back" var="WelcomeBack"/>
    <fmt:message key="message.login" var="login"/>
    <fmt:message key="message.password" var="password"/>
    <fmt:message key="message.phone.number" var="phoneNumber"/>
    <fmt:message key="message.registration" var="registration"/>
    <fmt:message key="message.welcome.back" var="WelcomeBack"/>
    <fmt:message key="message.email" var="email"/>
    <fmt:message key="message.status" var="status"/>
    <fmt:message key="button.remove" var="remove"/>
    <fmt:message key="message.user.id" var="userId"/>
    <fmt:message key="navigation.rus" var="navigationRU"/>
    <fmt:message key="navigation.eng" var="navigationENG"/>

</fmt:bundle>

    <html>
<head>
    <t:gHead>
    <title>Admin</title>
    </t:gHead>
</head>
<body>
<table>
    <c:forEach var="entities" items="${user}">
        <form action="/Controller/removeUser" method="post">
        <p><input type="hidden" name="id" value="${entities.getID}">
        <input type="submit" value="${remove}">
        </p></form>
        <div>
        <div>
        ${id} ${entities.getID()}
        </div>
        <div>
        ${phone_number} ${entities.getPhoneNumber()}
        </div>
        <div>
        ${login} ${entities.getLogin()}
        </div>
        <div>
        ${password} ${entities.getPassword()}
        </div>
        <div>
        ${email} ${entities.getEmail()}
        </div>
        <div>
        ${address_id} ${entities.getAddress_id()}
        </div>
        </div>
</table>
<form>

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
<p><a href="/Controller/welcome">${WelcomeBack}</a></p>
</body>
</html>