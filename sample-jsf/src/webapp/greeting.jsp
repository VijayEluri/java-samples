<HTML>
    <HEAD> <title>Hello</title> </HEAD>
    <%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
    <%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
    <body bgcolor="white">
    <f:view>
    <h:form id="helloForm">
      <h:outputText value="#{UserNumberBean.minimum}"/> to
      <h:outputText value="#{UserNumberBean.maximum}"/>.  
  	<h:inputText id="userNo" value="#{UserNumberBean.userNumber}" validator="#{UserNumberBean.validate}"/>          
	 <h:commandButton id="submit" action="success" value="Submit" />
	 <h:message style="color: red; font-family: 'New Century Schoolbook', serif; font-style: oblique; text-decoration: overline" id="errors1" for="userNo"/>
    </h:form>
    <h:form id="helloForm2">
	 <h:commandButton id="submit2" action="#{UserNumberBean.changeNumber}" value="Change" />
    </h:form>
    </f:view>
    </body>
</HTML>  
