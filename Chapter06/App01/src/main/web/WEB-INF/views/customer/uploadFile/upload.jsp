<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Upload file</title>
</head>
<body>
<h1>Upload file</h1>
<form method="post" enctype="multipart/form-data" action="/customer/uploadFile">
    <input type="file" name="uploadFile"/>
    <button type="submit">Upload</button>
</form>
</body>
</html>
