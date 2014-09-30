<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title>Tutorial: Multiple Select index</title>
<link rel="stylesheet" type="text/css" href="../css/global.css" />
</head>
<body>

<h1>Tutorial: Multiple Select index</h1>

<html:errors/>
<s:form>
multiselect:${f:h(multiselect)}<br />
<html:select property="multiselect" multiple="true" size="3">
<html:option value="1">One</html:option>
<html:option value="2">Two</html:option>
<html:option value="3">Three</html:option>
</html:select>
<br />
<input type="submit" name="submit" value="submit"/>
</s:form>
</body>
</html>