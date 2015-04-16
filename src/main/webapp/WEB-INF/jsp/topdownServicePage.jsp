<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Market Data</title>
	</head>
	<body>
		<h1>Market Data Services</h1>
		<h3>Current market data:</h3>
		<ul>
			<li>mock</li>
			<li>mock</li>
			<li>mock</li>
			<li>mock</li>
		</ul>
		
		<h3>Import Market Data</h3>
		<form action="#" th:action="@{/topdownServiceClient}" th:object="${marketData}" method="post">
			Stock Code:
			<input type="text" th:field="*{sec}" name="sec"></input>
			<br>
			Start Date:
			<input type="text" th:field="*{startDate}" name="startDate"></input>
			<br>
			End Date:
			<input type="text" th:field="*{endDate}" name="endDate"></input>
			<br>
			<input type="hidden" th:field="*{id}" name="id" value="marketData"></input>
			<input type="submit" value="Import">
		</form>
		<p>Response: <b><c:out value="${returnImportMarketData}"></c:out>
		</p>
		
		<br>
		<h3>Download Market Data</h3>
		<form action="#" th:action="@{/topdownServiceClient}" th:object="${fileData}" method="POST">
			<input type="text" th:field="*{eventSetId}" name="eventSetId"></input>
			<br>
			<input type="hidden" th:field="*{id}" name="id" value="fileData"></input>
			<input type="submit" value="Download">
		</form>
		<p>Response: <b><c:out value="${returnDownloadFileData}"></c:out></b></p>
	</body>
</html>