<%--
  Created by IntelliJ IDEA.
  User: arman
  Date: 6/22/2023
  Time: 11:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<html data-bs-theme="dark">
<head>
  <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
  <script type="text/javascript" src="/js/app.js"></script>
  
  <%--  TODO: TITLE--%>
  <title>Title</title>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <%-- TODO: NAVBAR BRAND AND HREF --%>
  <div class="container-fluid">
    <a href="/dashboard" class="navbar-brand">
      Application
    </a>
    <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarNav"
    >
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a href="/dashboard" class="nav-link">
            Home
          </a>
        </li>
      </ul>
      <a href="/logout" class="btn btn-outline-danger" role="button">
        Log Out
      </a>
    </div>
  </div>
</nav>
<main class="container-fluid p-5">
  <div class="d-flex justify-content-center mb-5">
    <div class="d-flex justify-content-center border" style="width: 800px; height: 800px">
      <div>
        <c:forEach items="${rows}" var="row">
          <div class="d-flex">
            <c:forEach items="${cols}" var="col">
              <c:choose>
                <c:when test="${(col + row) % 2 == 0}">
                  <div class="position-relative" style="background-color: rebeccapurple; width: 100px; height: 100px">
                    <p class="position-absolute">
                        ${cellMatrix[col - 1][row - 1]}
                    </p>
                    <c:if test="${pieceMap.containsKey(cellMatrix[col - 1][row - 1])}">
                      <img
                          src="${pieceMap.get(cellMatrix[col - 1][row - 1]).imageURL}">
                    </c:if>
                  </div>
                </c:when>
                <c:otherwise>
                  <div class="position-relative" style="background-color: blanchedalmond; width: 100px; height: 100px">
                    <p class="position-absolute">
                        ${cellMatrix[col - 1][row - 1]}
                    </p>
                    <c:if test="${pieceMap.containsKey(cellMatrix[col - 1][row - 1])}">
                      <img
                          src="${pieceMap.get(cellMatrix[col - 1][row - 1]).imageURL}">
                    </c:if>
                  </div>
                </c:otherwise>
              </c:choose>
            </c:forEach>
          </div>
        </c:forEach>
      </div>
    </div>
  </div>
  <div class="d-flex justify-content-between">
    <div>
      <c:forEach var="piece" items="${whitePieces}">
        <p>${piece.toString()}</p>
      </c:forEach>
    </div>
    <div>
      <c:forEach var="piece" items="${blackPieces}">
        <p>${piece.toString()}</p>
      </c:forEach>
    </div>
  </div>
</main>
</body>
</html>