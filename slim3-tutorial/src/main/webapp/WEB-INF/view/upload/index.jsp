<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title>Tutorial: Upload</title>
<link rel="stylesheet" type="text/css" href="../css/global.css" />
</head>
<body>

<h1>Tutorial: Upload</h1>
<p>
Upload data into src/main/webapp/WEB-INF/work directory.
</p>
<html:errors/>

<s:form enctype="multipart/form-data">
<input type="file" name="formFile" /><br />

<input type="submit" name="upload" value="upload"/>
</s:form>
</body>
</html>