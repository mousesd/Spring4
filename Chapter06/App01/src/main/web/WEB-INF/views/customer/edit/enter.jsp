<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Edit Customer</title>
</head>
<body>
<h1>Edit Customer</h1>
<%--@elvariable id="editCustomer" type="net.homenet.domain.Customer"--%>
<form:form method="post" modelAttribute="editCustomer">
    <dl>
        <dt>Name</dt>
        <dd>
            <form:input path="name"/>
            <form:errors path="name"/>
        </dd>
        <dt>Email</dt>
        <dd>
            <form:input path="emailAddress"/>
            <form:errors path="emailAddress"/>
            <form:errors path="ngEmail"/>
        </dd>
        <dt>Birthday</dt>
        <dd>
            <form:input path="birthDate"/>
            <form:errors path="birthDate"/>
        </dd>
        <dt>Favorite Number</dt>
        <dd>
            <form:input path="favoriteNumber"/>
            <form:errors path="favoriteNumber"/>
        </dd>
    </dl>
    <button type="submit" name="_event_proceed" value="proceed">Next</button>
</form:form>
</body>
</html>
