<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h3>Home</h3>
  <br />
  <h4>Welcome Spring Security !!!</h4>
  <br />
  <p>
    User Name : <security:authentication property="principal.username" />
    Role(s) : <security:authentication property="principal.authorities" />
  </p>  
  <hr />

  <security:authorize access="hasRole( 'MANAGER' )">
    <p>
      <a href="leaders">Leadership Meeting</a> ( Only for Manager )
    </p>
    <hr />
  </security:authorize>
  <security:authorize access="hasRole( 'ADMIN' )">
    <p>
      <a href="systems">System Conference</a> ( Only for System Admin )
    </p>
    <hr />
  </security:authorize>
  
<%--   <form:form action="${pageContext.request.contextPath}/logout" method="POST"> --%>
  <form:form action="logout" method="POST">
    <button type="submit" value="Logout">logout</button>
  </form:form>
</body>
</html>