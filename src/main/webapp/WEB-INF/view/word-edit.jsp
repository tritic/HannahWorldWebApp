<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Edit Word page</title>
</head>
<body>
<h1>Edit Word page</h1>
<form:form method="POST" commandName="word" action="${pageContext.request.contextPath}/word/edit/${word.id}.html" >
<table>
<tbody>
<tr>
<td>Word aword:</td>
<td><form:input path="aword" /></td>
</tr>
<tr>
<td>Week number:</td>
<td><form:input path="weekNumber" /></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="Edit" /></td>
</tr>
</tbody>
</table>
</form:form>
<a href="${pageContext.request.contextPath}/">Home page</a>
</body>
</html>
