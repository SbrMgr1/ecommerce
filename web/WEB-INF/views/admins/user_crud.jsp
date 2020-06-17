<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<%@ include file="../../layouts/admin_head.jsp"%>

<body>

<div id="wrapper">

    <%@ include file="../../layouts/admin_menu.jsp"%>

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">User Management</h1>

                <button class="btn btn-success add-edit-btn" style="margin-bottom: 15px" href="#demo" data-toggle="collapse">Add / Edit</button>
                <div id="demo" class="collapse">
                    <form id="my-form">
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label for="username">Name</label>
                                    <input type="text" class="form-control" id="username" placeholder="Username">
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label for="userEmail">Email Address</label>
                                    <input type="email" class="form-control" id="userEmail" placeholder="Email">
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label for="userPassword">Password</label>
                                    <input type="password" class="form-control" id="userPassword" placeholder="Password">
                                </div>
                            </div>
                        </div>
                        <input type="hidden" name="id" value="">
                        <button type="submit" style="margin-bottom: 15px" class="btn btn-primary">Save</button>
                    </form>
                </div>
                <c:set var="count" value="0" scope="page" />
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Name</th>
                        <th>Email Address</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${users_for_crud}" var="user">
                        <c:set var="count" value="${count + 1}" scope="page"/>
                        <tr data-key="${user.id}">
                            <td>${count}</td>
                            <td>${user.name}</td>
                            <td>${user.email}</td>
                            <td>
                                <a class="btn btn-primary btn-xs edit-btn"><i class="fa fa-edit"></i></a>
                                <a class="btn btn-danger btn-xs dlt-btn"><i class="fa fa-trash-o"></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->
<%@ include file="../../layouts/admin_footer.jsp"%>
<script src="<c:url value="/assets/js/user_crud.js"/>"></script>
</body>

</html>