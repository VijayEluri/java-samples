<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title>Tutorial: Updatable Nested Foreach</title>
<link rel="stylesheet" type="text/css" href="../css/global.css" />
</head>
<body>

<h1>Tutorial: Updatable Nested Foreach</h1>

<html:errors/>
<s:form>
<table border="1">
<c:forEach var="mapItems" varStatus="s" items="${mapItemsItems}">
    <tr>
    <c:forEach var="m" varStatus="s2" items="${mapItems}">
        <td>
            <input type="text"
                name="mapItemsItems[${s.index}][${s2.index}].id"
                value="${f:h(m.id)}"/>
        </td>
        <td>
            <input type="text"
                name="mapItemsItems[${s.index}][${s2.index}].name"
                value="${f:h(m.name)}"/>
        </td>
    </c:forEach>
    </tr>
</c:forEach>
</table><br />
<input type="submit" name="submit" value="submit"/>
</s:form>
</body>
</html>