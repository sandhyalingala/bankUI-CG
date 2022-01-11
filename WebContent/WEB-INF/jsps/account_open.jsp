<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:import url="header.jsp" />
 

<div class="container-fluid">
	<div class="row">
		<div class="col-lg-2"> </div>
	  	<div class="col-lg-8">
	  		
	  		<sf:form method="post" action="${pageContext.request.contextPath}/create-account" modelAttribute="customer">
  <fieldset>
    <legend>Account Creation</legend>
     
    <div class="form-group">
      <label for="exampleInputEmail1" class="form-label mt-4">Name</label>
      <sf:input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" 
       path="name" placeholder="Enter full name" />
      <small id="emailHelp" class="form-text text-muted">This should match with your name from AadharCard </small>
    </div>
     
     <div class="form-group">
      <label for="exampleInputEmail1" class="form-label mt-4">City</label>
      <sf:input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
      path="city" placeholder="Enter city" />
     </div>
    
    <div class="form-group">
      <label for="exampleInputEmail1" class="form-label mt-4">Address</label>
       <sf:textarea class="form-control" name="address"  aria-describedby="addressHelp" path="address" /></textarea>
             <small id="addressHelp" class="form-text text-muted">Address should match with your address on Pan card </small>
       
     </div>
     
     <div class="form-group">
      <label for="exampleInputEmail1" class="form-label mt-4">Pan Number</label>
      <sf:input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
      path="panNumber" placeholder="Enter your pan number" />
      	
     </div>
     
     <hr>
     <div class="form-group">
      <label for="exampleInputEmail1" class="form-label mt-4">Username</label>
      <sf:input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
      path="userInfo.username" placeholder="Enter your username" />
      	
     </div>
     
     <div class="form-group">
      <label for="exampleInputEmail1" class="form-label mt-4">Password</label>
      <sf:input type="password" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" 
      path="userInfo.password" placeholder="Enter your password" />
      	
     </div>
       <br /><br />
    <button type="submit" class="btn btn-primary">Create Account</button>
   
  </fieldset>
</sf:form>
	  		
	  	</div>
	  	<div class="col-lg-2"> </div>
	</div>
</div>
</body>
</html>