<%--
  Created by IntelliJ IDEA.
  User: samsherrana
  Date: 6/12/20
  Time: 7:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Footer -->
<footer class="page-footer font-small blue pt-4 theme-footer">

    <!-- Footer Links -->
    <div class="container-fluid text-center text-md-left">

        <!-- Grid row -->
        <div class="row">

            <!-- Grid column -->
            <div class="col-md-6 mt-md-0 mt-3">

                <!-- Content -->
                <h5 class="text-uppercase">${initParam.sitename}</h5>
                <p>Keep in touch</p>
                <p><i class="fa fa-facebook btn btn-sm btn-primary"></i>
                    <i class="fa fa-youtube btn btn-danger btn-sm"></i>
                    <i class="fa fa-twitter btn btn-info btn-sm"></i></p>

            </div>
            <!-- Grid column -->

            <hr class="clearfix w-100 d-md-none pb-3">

            <!-- Grid column -->
            <div class="col-md-3 mb-md-0 mb-3">

                <!-- Links -->
                <h5 class="text-uppercase">Quick Links</h5>

                <ul class="list-unstyled">
                    <li>
                        <a href="<c:url value="/"/>">Home</a>
                    </li>
                    <li>
                        <a href="<c:url value="/page/about-us"/>">About Us</a>
                    </li>
                    <li>
                        <a href="<c:url value="/page/terms-and-conditions"/>">Terms and Conditions</a>
                    </li>
                    <li>
                        <a href="<c:url value="/page/faq"/>">FAQ</a>
                    </li>
                    <li>
                        <a href="<c:url value="/page/privacy-policy"/>">Privacy Policy</a>
                    </li>
                </ul>

            </div>
            <!-- Grid column -->

            <!-- Grid column -->
            <div class="col-md-3 mb-md-0 mb-3">

                <!-- Links -->
                <h5 class="text-uppercase">Links</h5>

                <ul class="list-unstyled">
                    <li>
                        <a href="#!">Contact Us</a>
                    </li>
                    <li>
                        <a href="#!">Our Partners</a>
                    </li>
                </ul>

            </div>
            <!-- Grid column -->

        </div>
        <!-- Grid row -->

    </div>
    <!-- Footer Links -->

    <!-- Copyright -->
    <div class="footer-copyright text-center py-3">© 2020 Copyright:
        <a href="#"> Cosmic Ecommerce</a>
    </div>
    <!-- Copyright -->

</footer>
<!-- Footer -->
