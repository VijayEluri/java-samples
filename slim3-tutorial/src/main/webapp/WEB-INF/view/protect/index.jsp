<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title>Tutorial: Protect Index</title>
<link rel="stylesheet" type="text/css" href="../css/global.css" />
</head>
<body>

<h1>Tutorial: Protect Index</h1>

<html:errors/>
<p>
"tomcat" user and "role1" user can display this page. 
</p>
<br />
<s:form>
<input type="submit" name="tomcat"
  value="Only tomcat user can click this button"/>
</s:form>
</body>
</html>