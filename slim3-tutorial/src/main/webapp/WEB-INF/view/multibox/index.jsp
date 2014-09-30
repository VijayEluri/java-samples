<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title>Tutorial: Multibox index</title>
<link rel="stylesheet" type="text/css" href="../css/global.css" />
</head>
<body>

<h1>Tutorial: Multibox index</h1>

<html:errors/>
<s:form>
multibox:<br />
<c:forEach var="m" items="${multiboxItems}">
<html:multibox property="multibox" value="${m.value}"/>${f:h(m.label)}
</c:forEach><br />
<input type="submit" name="submit" value="submit"/>
</s:form>
</body>
</html>