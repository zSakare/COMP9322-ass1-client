<%@page import="java.util.ArrayList"%>
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
		<div style="width:100%;">
			<h1>Market Data Services</h1>
			<h3>Current market data:</h3>
			<ul>
				<% ArrayList<String> idList = (ArrayList) request.getAttribute("idList"); 
				for (String id : idList) { %>
					<li><a href="http://localhost:8080/EventSetDownloads/<%= id %>.csv"><%= id %></a></li>
				<% } %>
			</ul>
			<hr><br>
			
			<div style="float:left; width:45%; padding:20px">
				<h3>Import Market Data</h3>
				<form action="importMarketData" th:action="@{/importMarketData}" th:object="${marketData}" method="post">
					Stock Code:
					<input type="text" th:field="*{sec}" name="sec"></input>
					<br>
					Start Date: (DD-MM-YYYY)
					<input type="text" th:field="*{startDate}" name="startDate"></input>
					<br>
					End Date: (DD-MM-YYYY)
					<input type="text" th:field="*{endDate}" name="endDate"></input>
					<br>
					<input type="submit" value="Import">
				</form>
				<p>Response: <b><c:out value="${returnImportMarketData}"></c:out></b></p>
				<hr><br>
				
				<h3>Download Market Data</h3>
				<form action="downloadFile" th:action="@{/downloadFile}" th:object="${fileData}" method="POST">
					Event Set Id:
					<input type="text" th:field="*{eventSetId}" name="eventSetId"></input>
					<br>
					<input type="submit" value="Download">
				</form>
				<p>Response: <b><a href="${returnDownloadFileData}">${returnDownloadFileData}</a></b></p>
			</div>
			<div style="float:right; width:45%; padding:20px">
				<h3>Summarise Market Data</h3>
				<form action="summarise" th:action="@{/summarise}" th:object="${fileData}" method="POST">
					Event Set Id:
					<input type="text" th:field="*{eventSetId}" name="eventSetId"></input>
					<br>
					<input type="submit" value="Summarise">
				</form>
				<p>Response:<br>
					ID: <b><c:out value="${returnSummariseFileData.eventSetId}"></c:out></b><br>
					Security: <b><c:out value="${returnSummariseFileData.sec}"></c:out></b><br>
					Start Date: <b><c:out value="${returnSummariseFileData.startDate}"></c:out></b><br>
					End Date: <b><c:out value="${returnSummariseFileData.endDate}"></c:out></b><br>
					Currency: <b><c:out value="${returnSummariseFileData.currencyCode}"></c:out></b><br>
					File Size: <b><c:out value="${returnSummariseFileData.fileSize}"></c:out></b>
				</p>
				<hr><br>
				<h3>Convert Currency</h3>
<%-- 				<form action="convert" th:action="@{/convert}" th:object="${convertFileData}" method="POST">
					Event Set Id:
					<input type="text" th:field="*{eventSetId}" name="eventSetId"></input>
					<br>
					Target Currency:
					<input type="text" th:field="*{targetCurrency}" name="targetCurrency"></input>
					<br>
					Target Date: (YYYY-MM-DD)
					<input type="text" th:field="*{targetDate}" name="targetDate"></input>
					<br>
					<input type="submit" value="Convert">
				</form>
				<p>Response:<br></p> --%>
				<hr><br>
				
				<h3>Visualise Market Data</h3>
				<form action="visualise" th:action="@{/visualise}" th:object="${fileData}" method="POST">
					Event Set Id:
					<input type="text" th:field="*{eventSetId}" name="eventSetId"></input>
					<br>
					<input type="submit" value="Visualise">
				</form>
				<p>Response: <b><a href="${returnVisualiseFileData}">${returnVisualiseFileData}</a></b></p>
			</div>
		</div>
	</body>
</html>