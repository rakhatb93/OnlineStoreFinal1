<%--
  Created by IntelliJ IDEA.
  User: Rakhat
  Date: 02.02.2018
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${locale}"/>
<fmt:bundle basename="i18n.messages">
    <fmt:message key="message.user.status.removed" var="userStatusIsRemoved"/>
    <fmt:message key="message.back.to.admin.page" var="backToAdmin"/>
    <fmt:message key="message.welcome.back" var="backToWelcome"/>
</fmt:bundle>
<html>
<body>
${userStatusIsRemoved}
<p><a href="/Controller/admin">${backToAdmin}</a> </p>
<p><a href="/Controller/welcome">${backToWelcome}</a> </p>
</body>
</html>
