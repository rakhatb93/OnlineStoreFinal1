<%--
  Created by IntelliJ IDEA.
  User: Rakhat
  Date: 02.02.2018
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<fmt:setLocale value="${locale}"/>
<fmt:bundle basename="i18n.messages">
    <fmt:message key="message.error.in.system" var="errorInSystem"/>
    <fmt:message key="message.welcome.back" var="backToWelcome"/>
    <fmt:message key="message.back.to.user.page" var="backToUserPage"/>
</fmt:bundle>
>
<html>
<head>
    <t:gHead>
    <title>Error</title>
    </t:gHead>
</head>
<body>
<div>${errorInSystem}</div>
<p><a href="/Controller/welcome">${wlcomeBack}</a></p>
</body>
</html>
