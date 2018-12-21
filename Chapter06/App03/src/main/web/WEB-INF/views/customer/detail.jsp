<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Customer Detail</title>
</head>
<body>
<h1>Customer Detail</h1>
<%--@elvariable id="customer" type="net.homenet.domain.Customer"--%>
<dl>
    <dt>Name</dt>
    <dd><core:out value="${customer.name}"/></dd>
    <dt>Email Address</dt>
    <dd><core:out value="${customer.emailAddress}"/></dd>
    <dt>Birthday</dt>
    <dd><fmt:formatDate value="${customer.birthDate}" pattern="yyyy/MM/dd"/></dd>
    <dt>Favorite Number</dt>
    <dd><core:out value="${customer.favoriteNumber}"/></dd>
</dl>
<core:url value="/customer" var="url"/>
<a href="${url}">Customer List</a>
</body>
</html>
