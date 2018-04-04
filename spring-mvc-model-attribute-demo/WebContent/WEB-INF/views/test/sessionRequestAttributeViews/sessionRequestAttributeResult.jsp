<%--
  Created by IntelliJ IDEA.
  User: hivisonmoura
  Date: 2018-04-02
  Time: 10:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <spring:url value="/resources/test-main.css" var="testMainCSS"/>
    <link href="${testMainCSS}" rel="stylesheet"/>
    <title>Test Result</title>

</head>
<body>
<div align="center">
    <h1>@SessionAttribute Test Results</h1>
    <h3>${timeHeading}, ${durationHeading}</h3>
    <hr/>
    <h3>No of page visits in this season: <c:out value="${visitorcount.count}"/></h3>
    <h3>List of Visitors to this site</h3>

    <ul>
        <c:forEach var="visitor" items="${visitordata.visitors}">
            <li><br><c:out value="${visitor.name}"/>, <c:out value="${visitor.email}"/></li>
            </b></li>
        </c:forEach>
    </ul>
    <br/>
    <br/>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <a href="${contextPath}/visitorRegister/home" style="font-size: 20px">Generate Another Visitor</a>
</div>

</body>
</html>
