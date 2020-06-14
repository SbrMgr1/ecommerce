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
    <div class="container content form-group p-15">
       <div class="row item-box mt-15 form-group" style="padding: 15px;">
           <div class="col-lg-9">
               <table class="table table-striped">
                   <thead>
                   <tr>
                       <th>Product Name</th>
                       <th>Unit Price</th>
                       <th>Quantity</th>
                       <th>Total Price</th>
                   </tr>
                   </thead>
                   <tbody class="cart-item-body">
                   <c:forEach var="product" items="${products}" >
                       <tr class="item-container" data-key="${product.id}">
                           <td width="20%">
                               <a  href="#" data-key="${product.id}">
                                   <img src="<c:url value='/assets/images/${product.producImg}'/>" class="img-responsive">
                                   <p class="item-name">${product.name}</p>
                               </a>
                           </td>
                           <td class="unit-price" data-unitprice="${product.unitPrice}">
                               USD ${product.unitPrice}
                           </td>
                           <td>
                               <input class="form-control qty-input" type="number" min="1" value="${product.qty}">
                           </td>
                           <td class="total-price">
                               USD ${product.qty*product.unitPrice}
                           </td>
                           <td>
                               <a href="#" class="btn btn-danger remove-btn"><span class="glyphicon glyphicon-remove"></span></a>
                           </td>
                       </tr>
                   </c:forEach>
                   </tbody>
               </table>
           </div>
           <div class="col-lg-3 pt-15">
               <p style="font-weight: bold">Grand Total : USD <span class="grand-total">USD ${rand_total}</span></p>
               <a class="btn btn-info" href="<c:url value='/account/checkout'/>">Proceed to checkout <span class="glyphicon glyphicon-chevron-right"></span></a>
               <a class="btn btn-default mt-15" href="<c:url value='/'/>"><span class="glyphicon glyphicon-chevron-left"></span> Continue Shopping</a>
           </div>
       </div>
    </div>
    <%@include file="../layouts/footer.jsp"%>
  </body>
</html>
