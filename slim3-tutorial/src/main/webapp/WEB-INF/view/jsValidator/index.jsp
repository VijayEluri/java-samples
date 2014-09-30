<%@page pageEncoding="UTF-8"%>
<html>
<head>
<s:javascript method="submit"/>
<s:javascript method="submit2" staticJavascript="false"/>
<title>Tutorial: Javascript Validator</title>
<link rel="stylesheet" type="text/css" href="../css/global.css" />
</head>
<body>

<h1>Tutorial: Javascript Validator</h1>

<html:errors/>
<s:form>
<table>
<tr><td>aaa</td><td><html:text property="aaa"/></td></tr>
<tr><td>bbb</td><td><html:text property="bbb"/></td></tr>
</table>
<s:submit property="submit" jsValidate="true">aaa is required</s:submit>
<s:submit property="submit2" jsValidate="true">bbb is required</s:submit>
</s:form>
</body>
</html>