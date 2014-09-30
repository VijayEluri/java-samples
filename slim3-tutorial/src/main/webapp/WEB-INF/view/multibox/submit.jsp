<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title>Tutorial: Multibox submit</title>
<link rel="stylesheet" type="text/css" href="../css/global.css" />
</head>
<body>

<h1>Tutorial: Multibox submit</h1>
<s:form>
multibox:${f:h(multibox)}<br />
<input type="submit" name="moveToIndexPage" value="move to index page"/>
</s:form>
</body>
</html>