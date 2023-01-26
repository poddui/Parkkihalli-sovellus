<!DOCTYPE html>
<%@ page language="java" contentType="text/html; ISO-8859-15"  pageEncoding="ISO-8859-15"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet" href="/styles/appstyle.css"  type="text/css">
<title>Tapahtumaraportti</title>
</head>

<body>
	<h1>Tapahtumaraportti</h1>
	<div id ="container">
		<h2><c:out value="${viesti}" /></h2>
		<div id="nappi">
		<input type="button" name="admin-nappi" onclick="window.location.href='/home';" value="Takaisin" />
		</div>
	

	</div>
</body>
</html>
