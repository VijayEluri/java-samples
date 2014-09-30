<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>Hello</title>
</head>	
<body>
<div class="container">
	<h1>
		Create Account
	</h1>
	<div>	
		<form:form modelAttribute="hello" action="" method="post">
		  	<fieldset>		
				<legend>Hello Fields</legend>
				<p>
					<form:label	for="where" path="where" cssErrorClass="error">Where</form:label><br/>
					<form:input path="where" /> <form:errors path="where" />			
				</p>
				<p>	
					<input type="submit" />
				</p>
			</fieldset>
		</form:form>
	</div>
	<hr>	
</div>
</body>
</html>