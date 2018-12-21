<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Information</title>
</head>
<body>
<h1>The specified customer is not registered</h1>
<core:url value="/customer" var="url"/>
<a href="${url}">Back to the customer list</a>
</body>
</html>
