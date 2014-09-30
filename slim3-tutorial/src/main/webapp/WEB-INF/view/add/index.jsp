<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title>Tutorial: Add</title>
<link rel="stylesheet" type="text/css" href="../css/global.css" />
</head>
<body>
<h1>Tutorial: Add</h1>

<html:errors/>
<s:form>
<html:text property="arg1"/> +
<html:text property="arg2"/>
= ${f:h(result)}<br />
<input type="submit" name="submit" value="submit"/>
</s:form>
</body>
</html>