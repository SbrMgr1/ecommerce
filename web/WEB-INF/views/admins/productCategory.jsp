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


                    <button class="btn btn-success" href="#demo" data-toggle="collapse">AddCategory</button>

                    <div id="demo" class="collapse">

                        <form>
                            <div class="form-group">

                                <label for="catName">Product Category Name</label>
                                <input type="text" class="form-control" id="catName"

                                       aria-describedby="prodHelp" placeholder="Enter product Category name..">

                            </div>
                            <div class="form-group">

                                <label for="descrip">Description</label>
                                <textarea name="descrip" class="form-control" id="descrip"
                                          placeholder="Description..." rows="5" cols="100"></textarea>
                            </div>

                            <button type="submit" class="btn btn-primary" id="catSubmit">ADD</button>

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

                        <c:forEach items="${categoryList}" var="productCategory" >
                            <c:set var="count" value="${count + 1}" scope="page"/>
                            <tr>
                                <td><c:out value="${count}"/></td>
                                <td><c:out value="${productCategory.name}"/></td>
                                <td><c:out value="${productCategory.desc}"/> </td>
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
<%@ include file="../../layouts/admin_footer.jsp" %>
<script src="<c:url value="/assets/js/ProductCategory.js"/>"></script>

</body>

</html>
