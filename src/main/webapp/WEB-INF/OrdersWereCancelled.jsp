<%--
  Created by IntelliJ IDEA.
  User: Rakhat
  Date: 02.02.2018
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<fmt:setLocale value="${locale}"/>
<fmt:bundle basename="i18n.messages">
    <fmt:message key="message.orders.were.cancelled" var="OrdersWereCancelled"/>
    <fmt:message key="message.welcome.back" var="backToWelcome"/>
    <fmt:message key="message.back.to.user.page" var="backToUser"/>
</fmt:bundle>
<html>
<body>
${OrdersWereCancelled}
<p><a href="/Controller/welcome">${backToWelcome}</a></p>
<p><a href="/Controller/user">${backToUser}</a></p>
</body>
</html>
