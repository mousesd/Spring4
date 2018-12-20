<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Review Customer</title>
</head>
<body>
<h1>Review Customer</h1>
<%--@elvariable id="editCustomer" type="net.homenet.domain.Customer"--%>
<form method="post">
    <dl>
        <dt>Name</dt>
        <dd><core:out value="${editCustomer.name}"/></dd>
        <dt>Email</dt>
        <dd><core:out value="${editCustomer.emailAddress}"/></dd>
        <dt>Birthday</dt>
        <dd><fmt:formatDate value="${editCustomer.birthDate}" pattern="yyyy/MM/dd"/></dd>
        <dt>Favorite Number</dt>
        <dd><core:out value="${editCustomer.favoriteNumber}"/></dd>
    </dl>
    <button type="submit" name="_event_revise">Back</button>
    <button type="submit" name="_event_confirmed">Confirm</button>
</form>
</body>
</html>
