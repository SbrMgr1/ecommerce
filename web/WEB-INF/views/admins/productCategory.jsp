<%--
  Created by IntelliJ IDEA.
  User: deepak
  Date: 6/14/2020
  Time: 8:41 PM
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<%@ include file="../../layouts/admin_head.jsp" %>

<body>

<div id="wrapper">

    <%@ include file="../../layouts/admin_menu.jsp" %>

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Product Management</h1>


                <button class="btn btn-success add-edit-btn" href="#demo" data-toggle="collapse">AddCategory</button>

                <div id="demo" class="collapse">

                    <form id="catSubmit" method="post" >
                        <div class="form-group">
                            <input type="hidden" name="id">

                            <label for="name">Product Category Name</label>
                            <input type="text" class="form-control" id="name" name="name" placeholder="Enter product Category name.." required>

                        </div>
                        <div class="form-group">

                            <label for="desc">Description</label>
                            <textarea name="desc" class="form-control" id="desc"
                                      placeholder="Description..." rows="5" cols="100"></textarea>
                        </div>

                        <button type="submit" class="btn btn-primary">SAVE</button>

                    </form>


                </div>

                <table class="table table-hover" id="prod-cat-table">

                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Product-category Name</th>
                        <th>Product Description</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach items="${categoryList}" var="productCategory">
                        <c:set var="count" value="${count + 1}" scope="page"/>
                        <tr data-key="${productCategory.id}">
                            <td><c:out value="${count}"/></td>
                            <td><c:out value="${productCategory.name}"/></td>
                            <td><c:out value="${productCategory.desc}"/></td>
                            <td>
                                <button type="button" class="btn btn-xs btn-primary edit-btn"><i class="fa fa-edit"></i></button>
                                <button type="button" class="btn btn-xs btn-danger delete-btn"><i class="fa fa-trash-o"></i></button>
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
<%@ include file="../../layouts/admin_footer.jsp" %>
<script src="<c:url value="/assets/js/ProductCategory.js"/>"></script>

</body>

</html>
