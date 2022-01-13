<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 
</head>
<c:import url="../header.jsp" />
<body>
	<div class="container-fluid" style="margin-top: 3em">
		<div class="row">
			<div class="col-lg-1"></div>
			<div class="col-lg-10">
			<div class="alert alert-dismissible alert-warning" style="height: 55px">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="${pageContext.request.contextPath }/dashboard" style="text-decoration: none;">Dashboard</a></li>
						<li class="breadcrumb-item active" aria-current="page">Transfer</li>
					</ol>
				</nav>
				</div>
			</div>
			<div class="col-lg-1"></div>
		</div>
		
		<div class="row">
			<div class="col-lg-1"></div>
			<div class="col-lg-10">
			 
			 
			 <div class="card border-primary mb-3">
  <div class="card-header">Deposit</div>
  <div style="font-size:medium;  color: red" > <%=request.getAttribute("msg") %></div>
  <sf:form method="get" action="${pageContext.request.contextPath }/process-deposit" modelAttribute="transfer"> 
  <div class="card-body">
    <h5 class="card-title">Enter Account Number to Deposit Money</h5>
    <p class="card-text">
    Maximum limit for deposit at a time is 2 lakhs</p>
    
    <div class="form-group">
   <sf:input class="form-control form-control-lg" type="text" placeholder="account number " id="inputLarge" 
   path="toAccountNumber" />
</div>

	<hr />
	
	 <h5 class="card-title">Enter Amount to Deposit</h5>
    <p class="card-text">
    The money will be credited instantly to your account</p>
    
    <div class="form-group">
   <sf:input class="form-control form-control-lg" type="text" placeholder="amount" id="inputLarge" 
   path="amount" />
</div>
	
	<br /><br />
	<input type="submit" class="btn btn-primary btn-lg" value="Initiate Deposit" />
	
  </div>
  
  </sf:form>
</div>
			</div>
			<div class="col-lg-1"></div>
		</div>
	</div>
</body>
</html>