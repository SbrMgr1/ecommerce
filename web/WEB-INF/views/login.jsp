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
        <form class="col-md-offset-4 col-md-4" action="<c:url value="/login"/>" method="post">
          <h3>Login form</h3>
          <c:if test="${param.success_msg != null}">
            <div class="alert alert-success">
                ${param.success_msg}
            </div>
          </c:if>
          <div class="form-group">
            <label for="email">Email</label>
            <input type="text" class="form-control" id="email" name="email" value="${cookie.name.value}">
          </div>
          <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password">
          </div>
          <div class="form-group">
            <label>
              <input type="checkbox"
                     <c:if test="${cookie.containsKey('name')}">checked</c:if>
                     name="remember"> Remember me.
            </label>
          </div>
          <c:if test="${errors != null}"><div class="form-group text-danger">${errors}</div></c:if>
          <div class="form-group text-danger">${param.msg}</div>
          <div class="form-group">
            <button type="submit" class="btn btn-info"><span class="glyphicon glyphicon-log-in"></span> Signin</button>
          </div>
        </form>
      </div>
    </div>
    <%@include file="../layouts/footer.jsp"%>
  </body>
</html>
