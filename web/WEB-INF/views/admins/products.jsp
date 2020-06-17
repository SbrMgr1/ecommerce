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

        <button class="btn btn-success add-edit-btn" href="#demo" data-toggle="collapse">Add/Edit</button>
        <div id="demo" class="collapse">
          <form method="post" class="product-form">
            <div class="row">
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="product-name">Product Name</label>
                  <input type="text" class="form-control" id="product-name" name="name" placeholder="Product Name" required>
                </div>
              </div>
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="product-category">Product Category</label>
                  <select type="text" class="form-control" id="product-category" name="catId" required>
                    <option value="">Choose Product Category</option>
                    <c:forEach items="${catlist}" var="category">
                        <option value="${category.value.id}">${category.value.name}</option>
                    </c:forEach>
                  </select>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="product-image">Product Image</label>
                  <input type="file" id="product-image" name="producImg" >
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="product-unitPrice">Product Price</label>
                  <input type="number" min="0.00" step="any" class="form-control" id="product-unitPrice" name="unitPrice" placeholder="0.00" required>
                </div>
              </div>
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="product-tax">Tax</label>
                  <input type="number" min="0.00" step="any" class="form-control" id="product-tax" name="tax" placeholder="0.00" required>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="product-desc">Product Description</label>
                  <textarea class="form-control" name="desc" id="product-desc" rows="4"></textarea>
                </div>
              </div>
            </div>
            <input type="hidden" name="id">
            <div class="row">
            <div class="text-danger error-container col-sm-6"></div>
            </div>
            <button type="submit" style="margin-bottom: 15px" class="btn btn-success">Submit</button>
          </form>
        </div>
        <c:set var="count" value="0" scope="page" />
        <table class="table table-hover product-table">
          <thead>
          <tr>
            <th>#</th>
            <th>Product Name</th>
            <th style="width: 10%">Product Image</th>
            <th>Product Category</th>
            <th class="text-right">Unit Price</th>
            <th class="text-right">Tax</th>
            <th>Action</th>
          </tr>
          </thead>
          <tbody>

          <c:forEach items="${productList}" var="product" >
            <c:set var="count" value="${count + 1}" scope="page"/>
            <tr data-key="${product.id}" data-desc="${product.desc}">
              <td>${count}</td>
              <td>${product.name}</td>
              <td><img alt="${product.name}" class="img-responsive" src="<c:url value="/assets/images/${product.producImg}"/>"/></td>
              <td data-cat="${product.catId}">${catlist[product.catId].name}</td>
              <td class="text-right">${product.unitPrice}</td>
              <td class="text-right">${product.tax}</td>
              <td>
                <a class="btn btn-primary btn-xs edit-btn"><i class="fa fa-edit"></i></a>
                <a class="btn btn-danger btn-xs delete-btn"><i class="fa fa-trash-o"></i></a>
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
<script src="<c:url value="/assets/js/product.js"/>"></script>
</body>
</html>