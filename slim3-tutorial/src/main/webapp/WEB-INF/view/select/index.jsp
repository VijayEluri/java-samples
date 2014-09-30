<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title>Tutorial: Select</title>
<link rel="stylesheet" type="text/css" href="../css/global.css" />
</head>
<body>

<h1>Tutorial: Select</h1>

<html:errors/>
<s:form>
<html:select property="select">
<html:option value="1">One</html:option>
<html:option value="2">Two</html:option>
<html:option value="3">Three</html:option>
</html:select>
<br />
${f:h(select)}<br />
<input type="submit" name="submit" value="submit"/>
</s:form>
</body>
</html>