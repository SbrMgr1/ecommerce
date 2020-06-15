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
                <h1 class="page-header">CMS Page</h1>

                <button class="btn btn-success" href="#demo" data-toggle="collapse">Collapsible</button>
                <div id="demo" class="collapse">
                   <div class="form-group">
                       <label>Title</label><input type="text" name="title" id="title" class="form-control">
                       <label>Slug</label><input type="text"  name="title" id="slug" class="form-control">
                       <label>Description</label><textarea name="description" id="description" rows="40" cols="100" class="form-control">Your Description here</textarea>
                       <input type="submit" name="submit" value="submit" class="btn btn-success" id="cmsSubmit">
                   </div>
                </div>
                <table class="table table-hover" id="cms-table">
                    <thead>
                    <tr>
                        <th>Title</th>
                        <th>Slug</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>John</td>
                        <td>john@example.com</td>
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
<%@ include file="../../layouts/admin_footer.jsp"%>
</body>

</html>