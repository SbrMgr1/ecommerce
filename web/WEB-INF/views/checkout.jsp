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
<div class="container content text-center p-15">
    <div class="alert alert-success">
        <strong>Success!</strong> Checked out successfully.
    </div>
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
            <tr>
                <td width="20%">
                    <a class="item-container" href="#" data-key="${product.id}">
                        <img src="<c:url value='/assets/images/${product.producImg}'/>" class="img-responsive">
                        <p class="item-name">${product.name}</p>
                    </a>
                </td>
                <td class="unit-price" data-unitprice="${product.unitPrice}">
                    USD ${product.unitPrice}
                </td>
                <td>
                        ${product.qty}
                </td>
                <td class="total-price">
                    USD ${product.qty*product.unitPrice}
                </td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="2">
            </td>
            <td>
                Your Total:
            </td>
            <td>
                USD ${rand_total}
            </td>
        </tr>
        </tfoot>
    </table>
</div>
<%@include file="../layouts/footer.jsp"%>
</body>
</html>
</title>
</head>
<body>

</body>
</html>
