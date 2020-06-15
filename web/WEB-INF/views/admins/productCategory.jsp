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

                    <button class="btn btn-success" href="#demo" data-toggle="collapse">Collapsible</button>
                    <div id="demo" class="collapse">

                        <form>
                            <div class="form-group">
                                <label for="exampleInputProd">Product Category Name</label>
                                <input type="text" class="form-control" id="exampleInputProd"
                                       aria-describedby="prodHelp" placeholder="Enter product Category name..">

                            </div>
                            <div class="form-group">
                                <label for="exampleInputDesc">Description</label>
                                <input type="text" class="form-control" id="exampleInputDesc"
                                       placeholder="Description...">
                            </div>

                            <button type="submit" class="btn btn-primary">Save</button>
                        </form>


                    </div>
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Product-category Name</th>
                            <th>Product Description</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>Electronics</td>
                            <td>Clothes</td>
                            <td>Hardware</td>
                            <td>john@example.com</td>
                            <td>
                                <a class="btn btn-primary btn-xs"><i class="fa fa-edit"></i></a>
                                <a class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i></a>
                            </td>
                        </tr>
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
    </body>

    </html>


</div>
<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
</div>
<!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->
<%@ include file="../../layouts/admin_footer.jsp" %>
</body>

</html>
