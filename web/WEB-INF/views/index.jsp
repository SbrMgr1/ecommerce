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
       <div class="row">
           <c:forEach var="product" items="${products}" >
               <c:set value="" var="added_var"></c:set>
               <c:set value="" var="added_var_sec"></c:set>
               <c:if test="${sessionScope.cart_item != null}">
                   <c:if test="${sessionScope.cart_item.containsKey(product.id)}">
                       <c:set value="added" var="added_var"></c:set>
                       <c:set value="fa fa-check" var="added_var_sec"></c:set>
                   </c:if>
               </c:if>
               <a class="item-container ${added_var}" href="#" data-key="${product.id}">
                   <div class="col-lg-3 col-md-3 col-sm-6">
                       <div class="item-box form-group mt-15 col-xs-12 pb-15 pt-15">
                           <img src="<c:url value='/assets/images/${product.producImg}'/>" class="img-responsive mt-15">
                           <p class="item-name">${product.name}</p>
                           <p><span class="glyphicon glyphicon-heart-empty favourite-tag"></span> <span class="price-tag">USD ${product.unitPrice}</span></p>
                           <button class="btn btn-info add-to-cart-btn">Add to Cart <span class="check-icon ${added_var_sec}"></span>
                           </button>
                       </div>
                   </div>
               </a>
           </c:forEach>
           <c:if test="${products.size() == 0}">
               <div class="col-lg-12 text-center" style="padding-top: 100px;padding-bottom: 100px;">No Products.</div>
           </c:if>

       </div>
    </div>
    <%@include file="../layouts/footer.jsp"%>
  </body>
</html>
