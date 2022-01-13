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
						<li class="breadcrumb-item active" aria-current="page">Account Settings</li>
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
  <div class="card-header"> Edit Account</div>
  
  <form > 
  <div class="card-body">
    
    
    <div class="form-group">
  <fieldset disabled="">
    <label class="form-label" for="disabledInput">Username</label>
    <input class="form-control" id="disabledInput" type="text" placeholder="Disabled input here..." disabled="">
  </fieldset>
</div>

	<hr />
	
	 <h5 class="card-title">Password</h5>
    
    <div class="form-group">
   <input class="form-control form-control-lg" type="text" placeholder="amount" id="inputLarge" 
   />
</div>
<h5 class="card-title">Address1</h5>
    
    <div class="form-group">
   <input class="form-control form-control-lg" type="text" placeholder="amount" id="inputLarge" 
   />
</div>
<h5 class="card-title">Address2</h5>
    
    <div class="form-group">
   <input class="form-control form-control-lg" type="text" placeholder="amount" id="inputLarge" 
   />
</div>
<h5 class="card-title">city</h5>
    
    <div class="form-group">
   <input class="form-control form-control-lg" type="text" placeholder="amount" id="inputLarge" 
   />
</div>

	
	<br /><br />
	<input type="submit" class="btn btn-primary btn-lg" value="EDIT" />
	
  </div>
  
  </form>
</div>
			</div>
			<div class="col-lg-1"></div>
		</div>
	</div>
</body>
</html>