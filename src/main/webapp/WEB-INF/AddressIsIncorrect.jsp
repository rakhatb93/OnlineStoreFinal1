<%--
  Created by IntelliJ IDEA.
  User: Rakhat
  Date: 02.02.2018
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${locale}"/>
<fmt:bundle basename="i18n.messages">
    <fmt:message key="message.back.to.user.page" var="backToClUser"/>
    <fmt:message key="message.address.is.not.correct" var="address is incorrect"/>
</fmt:bundle>
<html>
<body>
${addressIsIncorrect}
<p><a href="/Controller/user">${backToClUser}</a> </p>
</body>
</html>
