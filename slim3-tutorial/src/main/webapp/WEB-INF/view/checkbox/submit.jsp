<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title>Tutorial: Checkbox submit</title>
<link rel="stylesheet" type="text/css" href="../css/global.css" />
</head>
<body>

<h1>Tutorial: Checkbox submit</h1>

<html:errors/>
check1:${f:h(check1)}<br />
check2:${f:h(check2)}<br />
<s:form>
<input type="submit" name="moveToIndexPage" value="move to index page"/>
</s:form>
</body>
</html>