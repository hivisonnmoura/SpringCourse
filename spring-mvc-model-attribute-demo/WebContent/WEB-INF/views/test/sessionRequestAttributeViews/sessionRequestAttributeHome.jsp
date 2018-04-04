<%--
  Created by IntelliJ IDEA.
  User: hivisonmoura
  Date: 2018-04-02
  Time: 9:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <spring:url value="/resources/test-main.css" var="testMainCSS"/>
    <link href="${testMainCSS}" rel="stylesheet"/>
    <%--<link href="<c:url value="/resources/test-main.css" rel="stylesheet"/>--%>

    <title>Test Bed</title>
</head>
<body>
<div align="center">
    <h1>@SessionAttribute Test Bed</h1>
    <hr>
    <form:form action="visitor" modelAttribute="visitorstats" >
        <table>
            <tr>
                <td><form:label path="currentVisitorName">Name</form:label></td>
                <td><form:input path="currentVisitorName"/></td>
            </tr>
            <tr>
                <td><form:label path="currentVisitorEmail">Email</form:label></td>
                <td><form:input path="currentVisitorEmail"/></td>
            </tr>
            <tr>
                <td align="center"><input type="submit" value="submit"/></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
