<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Customer List</title>
</head>
<body>
<h1>Customer List</h1>
<%--@elvariable id="editCustomer" type="net.homenet.domain.Customer"--%>
<core:if test="${editCustomer != null}">
    Updated the below customer.
    <dl>
        <dt>Name</dt>
        <dd><core:out value="${editCustomer.name}"/></dd>
        <dt>Email Address</dt>
        <dd><core:out value="${editCustomer.emailAddress}"/></dd>
        <dt>Birthday</dt>
        <dd><fmt:formatDate value="${editCustomer.birthDate}" pattern="yyyy/MM/dd"/></dd>
        <dt>Favorite Number</dt>
        <dd><core:out value="${editCustomer.favoriteNumber}"/></dd>
    </dl>
</core:if>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email address</th>
        <th></th>
    </tr>
    <core:forEach items="${customers}" var="customer">
        <tr>
            <td><core:out value="${customer.id}"/></td>
            <td><core:out value="${customer.name}"/></td>
            <td><core:out value="${customer.emailAddress}"/></td>
            <td>
                <core:url value="/customer/${customer.id}" var="url"/>
                <a href="${url}">Detail</a>
                <core:url value="/customer/${customer.id}/edit" var="url"/>
                <a href="${url}">Edit</a>
            </td>
        </tr>
    </core:forEach>
</table>
<core:url value="/customer/uploadFile" var="url"/>
<a href="${url}">Upload File</a>
</body>
</html>
