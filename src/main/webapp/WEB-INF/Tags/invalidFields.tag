<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="invalidFields" %>
<c:forEach var="invalidField" items="${invalidFields}">
    <div>
            ${invalidField}
    </div>
</c:forEach>