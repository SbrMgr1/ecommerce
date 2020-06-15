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

        <button class="btn btn-success" href="#demo" data-toggle="collapse">Add/Edit</button>
        <div id="demo" class="collapse">
          <form method="post">
            <div class="row">
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="product-name">Product Name</label>
                  <input type="text" class="form-control" id="product-name" name="name" placeholder="Product Name">
                </div>
              </div>
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="product-category">Product Category</label>
                  <input type="text" class="form-control" id="product-category" name="catId" placeholder="Product Category">
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-6">
                <label for="product-image">Product Image</label>
                <input type="file" id="product-image" name="producImg" >
              </div>
            </div>
            <div class="row">
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="product-unitPrice">Product Price</label>
                  <input type="text" class="form-control" id="product-unitPrice" name="unitPrice" placeholder="Product Name">
                </div>
              </div>
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="product-tax">Tax</label>
                  <input type="text" class="form-control" id="product-tax" name="tax" placeholder="Tax">
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="product-desc">Product Image</label>
                  <textarea class="form-control" name="desc" id="product-desc" rows="4"></textarea>
                </div>
              </div>
            </div>
            <button type="submit" style="margin-bottom: 15px" class="btn btn-success">Submit</button>
          </form>
        </div>
        <c:set var="count" value="0" scope="page" />
        <table class="table table-hover">
          <thead>
          <tr>
            <th>#</th>
            <th>Product Name</th>
            <th>Unit Price</th>
            <th>Product Category</th>
            <th>Action</th>
          </tr>
          </thead>
          <tbody>

          <c:forEach items="${productList}" var="product" >
            <c:set var="count" value="${count + 1}" scope="page"/>
                <tr>
                  <td>${count}</td>
                  <td>${product.name}</td>
                  <td>${product.unitPrice}</td>
                  <td>${product.catId}</td>
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