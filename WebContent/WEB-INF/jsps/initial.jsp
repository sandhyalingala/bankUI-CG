<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<c:import url="header.jsp" />
<body>
<div class="btn-group" role="group" aria-label="Basic radio toggle button group">
  <input type="radio" class="btn-check" name="btnradio" id="btnradio1" autocomplete="off" checked="">
  <label class="btn btn-outline-primary" for="btnradio1">Radio 1</label>
  <input type="radio" class="btn-check" name="btnradio" id="btnradio2" autocomplete="off" checked="">
  <label class="btn btn-outline-primary" for="btnradio2">Radio 2</label>
  
</div>
</body>
</html>