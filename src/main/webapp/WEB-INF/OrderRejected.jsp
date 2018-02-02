<%--
  Created by IntelliJ IDEA.
  User: Rakhat
  Date: 02.02.2018
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${locale}"/>
<fmt:bundle basename="i18n.messages">
    <fmt:message key="message.order.rejected" var="orderRejected"/>
    <fmt:message key="message.back.to.manager.page" var="backToManager"/>
</fmt:bundle>
<html>
<body>
${orderRejected}
<p><a href="/Controller/manager">${backToManager}</a></p>
</body>
</html>
