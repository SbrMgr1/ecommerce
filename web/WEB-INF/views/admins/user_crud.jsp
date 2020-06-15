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
                <h1 class="page-header">Product Management</h1>

                <button class="btn btn-success" style="margin-bottom: 15px" href="#demo" data-toggle="collapse">Collapsible</button>
                <div id="demo" class="collapse">
                    <form>
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Email address</label>
                                    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Password</label>
                                    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                                </div>
                            </div>
                        </div>
                        <button type="submit" style="margin-bottom: 15px" class="btn btn-default">Submit</button>
                    </form>
                </div>
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>User Id</th>
                        <th>User Name</th>
                        <th>Email</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${}" var="user">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.name}</td>
                            <td>${user.email}</td>
                            <td>
                                <a class="btn btn-primary btn-xs"><i class="fa fa-edit"></i></a>
                                <a class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i></a>
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
</body>

</html>