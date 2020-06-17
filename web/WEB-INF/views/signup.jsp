<%--
  Created by IntelliJ IDEA.
  User: samsherrana
  Date: 6/12/20
  Time: 7:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <%@ include file="../layouts/head.jsp"%>
  <body>
    <%@include file="./../layouts/header.jsp"%>
    <div class="container content p-15">
      <div class="mt-100 mb-100 row">
        <form class="col-md-offset-4 col-md-4" action="<c:url value="/signup"/>" method="post">
          <h3>Registration form</h3>
          <div class="form-group">
            <label for="email">Name</label>
            <input type="text" class="form-control" id="name" name="name" value="${param.name}">
          </div>
          <div class="form-group">
            <label for="email">Email</label>
            <input type="text" class="form-control" id="email" name="email" value="${param.email}">
          </div>
          <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password" value="${param.password}">
          </div>

          <c:if test="${errors != null}"><div class="form-group text-danger">${errors}</div></c:if>
          <div class="form-group">
            <button type="submit" class="btn btn-info"><span class="glyphicon glyphicon-log-in"></span> Signin</button>
          </div>
        </form>
      </div>
    </div>
    <%@include file="../layouts/footer.jsp"%>
  </body>
</html>
