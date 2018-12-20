<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Edited Customer</title>
</head>
<body>
<!-- Refresh, Back button 클릭시 예외가 발생하는 문제가 있음 -->
<h1>Edited Customer</h1>
<%--@elvariable id="editCustomer" type="net.homenet.domain.Customer"--%>
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
<core:url var="url" value="/customer"/>
<a href="${url}">Back to the list</a>
</body>
</html>
