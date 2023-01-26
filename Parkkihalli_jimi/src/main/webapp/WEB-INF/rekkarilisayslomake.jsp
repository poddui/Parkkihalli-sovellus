<!DOCTYPE html>
<%@ page language="java" contentType="text/html; ISO-8859-15"  pageEncoding="ISO-8859-15"%>
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet" href="/styles/appstyle.css"  type="text/css">
<title>Parkkihalli</title>
</head>

<body>
	<input type="button" name="admin-nappi" onclick="window.location.href='/admin';" value="Hallintapaneeli" />
	<h1>Pysäköi autosi</h1>
	<div id="tauludiv">
<table id="hinnoittelu" >
		<tr>
			<th>Aloitusmaksu</th>
			<th>Hinta per minuutti</th>
		</tr>
		<tr>
			<td>6¤</td>
			<td>0,05¤</td>
	</table>
	</div>
	<div id ="container">
	<form action="/home" method="post">
		<div id="rekkaridiv">
		<p>
			 <input type="text" name="registrationNumber" id="registrationNumber" class="form-control input-lg" placeholder="ABC-123" size="10" maxlength="17" value="">
		</p>
		</div>
		<div id="nappi">
		<input type="submit" name="submit-button" class="btn btn-success" value="Pysäköi auto" />
		</div>
	</form>

	</div>
</body>
</html>