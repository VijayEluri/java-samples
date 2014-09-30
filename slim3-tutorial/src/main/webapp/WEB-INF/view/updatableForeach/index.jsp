<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title>Tutorial: Updatable Foreach</title>
<link rel="stylesheet" type="text/css" href="../css/global.css" />
</head>
<body>

<h1>Tutorial: Updatable Foreach</h1>
<html:errors/>
<s:form>
<table border="1">
<c:forEach var="m" varStatus="s" items="${mapItems}">
<tr>
<td><input type="text" name="mapItems[${s.index}].id" value="${f:h(m.id)}"/></td>
<td><input type="text" name="mapItems[${s.index}].name" value="${f:h(m.name)}"/></td>
</tr>
</c:forEach>
</table><br />
<input type="submit" name="submit" value="submit"/>
</s:form>
</body>
</html>