<%@ page import="models.Product" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: samsherrana
  Date: 6/12/20
  Time: 7:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="" style="padding-top: 20px">
        <div class="container theme-header-top">
            <div class="col-sm-2 col-sm-text-center"><a href="<c:url value="/" />"><img src="<c:url value="/assets/images/logo.jpg"/>"></a></div>
            <div class="col-sm-9">
                <form action="<c:url value="/" />">
                    <div class="input-group">
                        <div class="input-group-btn">
                            <div class="btn-group">
                                <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">
                                    <span>Search Options</span> <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu criteria" role="menu">
                                    <li>
                                        <label><input type="radio" name="priceSort" value="asc"> Price Low to High</label>
                                    </li>
                                    <li>
                                        <label><input type="radio" name="priceSort" value="desc"> Price High to Low</label>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <input type="text" name="param" class="form-control" placeholder="Search by name">
                        <span class="input-group-addon theme-input-group-addon">
                            <button type="submit">
                                <i class="glyphicon glyphicon-search"></i>
                            </button>
                        </span>
                    </div>
                </form>
            </div>
            <div class="col-sm-1">
                <div class="item-indicate">
                    <a
                            href="<c:url value="/cart-details" />"
                    ><span class="glyphicon glyphicon-shopping-cart"></span>
                        <c:set var="cart_cnt" value="0"></c:set>
                        <c:if test="${sessionScope.cart_item != null}">
                            <c:set var="cart_cnt" value="${sessionScope.cart_item.size()}"></c:set>
                        </c:if>

                        <span class="item-count">${cart_cnt}</span>
                    </a>
                </div>
            </div>
        </div>
    <div class="container-fluid theme-header-top-second">
        <div class="container">
            <div class="row">

                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand active" href="<c:url value="/" />"><span class="fa fa-home"></span> Home</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="<c:url value='/page/about-us'/>"><span class="fa fa-info-circle"></span> About Us</a></li>
                        <c:choose>
                            <c:when test="${sessionScope.userInfo != null}">
                                <li>
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-user"></span> My account <span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li>
                                            <a href="<c:url value="/account"/>"><span class="fa fa-dashboard"></span> Dashboard</a>
                                        </li>
                                        <li>
                                            <a href="<c:url value="/account/change-password"/>"><span class="fa fa-user"></span> ${sessionScope.userInfo.email}</a>
                                        </li>
                                        <li>
                                            <a href="<c:url value="/logout"/>"><span class="fa fa-sign-out"></span> Logout</a>
                                        </li>
                                    </ul>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li>
                                    <a
                                            href="<c:url value="/login"/>"><span class="fa fa-sign-in"></span> Sign in
                                    </a>
                                </li>
                                <li><a href="<c:url value='/signup'/>"><span class="fa fa-user"></span> Join Us</a></li>
                            </c:otherwise>
                        </c:choose>
                        <%--                <li class="dropdown">--%>
                        <%--                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>--%>
                        <%--                    <ul class="dropdown-menu">--%>
                        <%--                        <li><a href="#">Action</a></li>--%>
                        <%--                        <li><a href="#">Another action</a></li>--%>
                        <%--                        <li><a href="#">Something else here</a></li>--%>
                        <%--                        <li role="separator" class="divider"></li>--%>
                        <%--                        <li><a href="#">Separated link</a></li>--%>
                        <%--                        <li role="separator" class="divider"></li>--%>
                        <%--                        <li><a href="#">One more separated link</a></li>--%>
                        <%--                    </ul>--%>
                        <%--                </li>--%>
                    </ul>
                    <%--            <ul class="nav navbar-nav navbar-right">--%>
                    <%--                <li><a href="#">Link</a></li>--%>
                    <%--                <li class="dropdown">--%>
                    <%--                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>--%>
                    <%--                    <ul class="dropdown-menu">--%>
                    <%--                        <li><a href="#">Action</a></li>--%>
                    <%--                        <li><a href="#">Another action</a></li>--%>
                    <%--                        <li><a href="#">Something else here</a></li>--%>
                    <%--                        <li role="separator" class="divider"></li>--%>
                    <%--                        <li><a href="#">Separated link</a></li>--%>
                    <%--                    </ul>--%>
                    <%--                </li>--%>
                    <%--            </ul>--%>
                </div><!-- /.navbar-collapse -->
            </div>
        </div>
    </div>
    </div><!-- /.container-fluid -->
</nav>
