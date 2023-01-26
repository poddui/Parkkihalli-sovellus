
<%@ page language="java" contentType="text/html; ISO-8859-15"  pageEncoding="ISO-8859-15"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8" />
<title>Autot</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
<link rel="stylesheet" href="/styles/admincss.css"  type="text/css">
</head>
<body>
	<input type="button" name="lisää-nappi" onclick="window.location.href='/home';" value="Takaisin" />
	<h1>Hallintapaneeli</h1>
	<table class="table table_striped" id="taulus">
		<tr>
			<th>Rekisterinumero</th>
			<th>Pysäköintiaika</th>
			<th>Nykyinen aika</th>
			<th>Tämänhetkinen hinta (¤)</th>
			<th></th>
		</tr>
		<c:forEach items="${hallit}" var="hallit">
			
			<tr>
				<td><c:out value="${hallit.rekkari}" /></td> 
				<td><c:out value="${hallit.pysAika}" /></td> 
				<td><c:out value="${hallit.nykyHetki}" /></td> 
				<td><c:out value="${hallit.hinta} ¤" /></td> 
				<td><a href="/poista-rekkari?rekkari=<c:out value='${hallit.rekkari}'/>" id="poistologo">Poista</a></td>
		</c:forEach>
	</table>
</body>
</html>