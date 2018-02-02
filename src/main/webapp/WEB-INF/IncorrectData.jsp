<%--
  Created by IntelliJ IDEA.
  User: Rakhat
  Date: 02.02.2018
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${locale}"/>
<fmt:bundle basename="i18n.messages">
    <fmt:message key="message.incorrect.data" var="incorrectData"/>
    <fmt:message key="message.back.to.login" var="backToLogin"/>
</fmt:bundle>
<html>
<body>
${incorrectData}
<p><a href="/Controller/login">${backToLogin}</a> </p>
</body>
</html>
