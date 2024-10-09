<%-- 
    Document   : compare.jsp
    Created on : Oct 7, 2024, 10:04:32 PM
    Author     : PHONG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aroma Shop - Compare Laptop</title>
        <link rel="icon" href="img/Fevicon.png" type="image/png">
    </head>
    <body>
        <!--================ Start Header Menu Area =================-->
        <%@include file="header.jsp" %>
        <!--================ End Header Menu Area =================-->

        <!-- ================ start banner area ================= -->	
        <section class="blog-banner-area" id="category">
            <div class="container h-100">
                <div class="blog-banner">
                    <div class="text-center">
                        <h1>Compare Laptop</h1>
                    </div>
                </div>
            </div>
        </section>
        <!-- ================ end banner area ================= -->



        <div class="container">
            <table class="table table-bordered">
                <colgroup>
                    <col style="width: 25%;">
                    <col style="width: 25%;">
                    <col style="width: 25%;">
                    <col style="width: 25%;">
                </colgroup>
                <thead>
                    <tr>
                        <th class="align-top">
                            <h4>So sánh laptop </h4>
                            <h6>${img1.productDetail.product.name}</h6>
                        </th>
                        <th>
                            <div style="height: 100%; display: flex; flex-direction: column; justify-content: space-between;" >
                                <a href="information?productId=${img1.productDetail.id}" class="product-link" style="display: block; height: 100%; text-decoration: none; color: inherit;">

                                    <!-- Hiển thị ảnh sản phẩm -->
                                    <img src="${img1.image}" style="max-width: 100%; height: auto;">

                                    <!-- Hiển thị thương hiệu -->
                                    <div class="brand">${img1.productDetail.product.brand.name}</div>

                                    <!-- Hiển thị tên sản phẩm -->
                                    <h5>${img1.productDetail.product.name}</h5>

                                    <!-- Hiển thị giá tiền -->
                                    <p>Giá: ${img1.productDetail.price}</p>

                                </a>
                            </div>
                        </th>
                        <th>
                            <c:if test="${empty img2}">
                                <button id="openModal">Mở Modal</button>
                            </c:if>
                            <c:if test="${!empty img2}">
                                <div style="height: 100%; display: flex; flex-direction: column; justify-content: space-between;" >
                                    <a href="information?productId=${img2.productDetail.id}" class="product-link" style="display: block; height: 100%; text-decoration: none; color: inherit;">

                                        <!-- Hiển thị ảnh sản phẩm -->
                                        <img src="${img2.image}" style="max-width: 100%; height: auto;">

                                        <!-- Hiển thị thương hiệu -->
                                        <div class="brand">${img2.productDetail.product.brand.name}</div>

                                        <!-- Hiển thị tên sản phẩm -->
                                        <h5>${img2.productDetail.product.name}</h5>

                                        <!-- Hiển thị giá tiền -->
                                        <p>Giá: ${img2.productDetail.price}</p>

                                    </a>
                                </div>
                            </c:if>

                        </th>
                        <th>
                            <div style="height: 100%; display: flex; flex-direction: column; justify-content: space-between;" >
                                <a href="information?productId=${img3.productDetail.id}" class="product-link" style="display: block; height: 100%; text-decoration: none; color: inherit;">

                                    <!-- Hiển thị ảnh sản phẩm -->
                                    <img src="${img3.image}" style="max-width: 100%; height: auto;">

                                    <!-- Hiển thị thương hiệu -->
                                    <div class="brand">${img3.productDetail.product.brand.name}</div>

                                    <!-- Hiển thị tên sản phẩm -->
                                    <h5>${img3.productDetail.product.name}</h5>

                                    <!-- Hiển thị giá tiền -->
                                    <p>Giá: ${img3.productDetail.price}</p>

                                </a>
                            </div>
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item1" items="${list1}" varStatus="status1">
                        <tr>
                            <td>${item1.attribute.name}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${status1.index < fn:length(list1)}">
                                        ${list1[status1.index].value}
                                    </c:when>
                                    <c:otherwise>
                                        <!-- Ô trống nếu list2 ngắn hơn -->
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${status1.index < fn:length(list2)}">
                                        ${list2[status1.index].value}
                                    </c:when>
                                    <c:otherwise>
                                        <!-- Ô trống nếu list3 ngắn hơn -->
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${status1.index < fn:length(list3)}">
                                        ${list3[status1.index].value}
                                    </c:when>
                                    <c:otherwise>
                                        <!-- Ô trống nếu list4 ngắn hơn -->
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>

            </table>
        </div>



        <!-- ================ Subscribe section start ================= -->		  
        <section class="subscribe-position">
            <div class="container">
                <div class="subscribe text-center">
                    <h3 class="subscribe__title">Get Update From Anywhere</h3>
                    <p>Bearing Void gathering light light his eavening unto dont afraid</p>
                    <div id="mc_embed_signup">
                        <form target="_blank" action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01" method="get" class="subscribe-form form-inline mt-5 pt-1">
                            <div class="form-group ml-sm-auto">
                                <input class="form-control mb-1" type="email" name="EMAIL" placeholder="Enter your email" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Your Email Address '" >
                                <div class="info"></div>
                            </div>
                            <button class="button button-subscribe mr-auto mb-1" type="submit">Subscribe Now</button>
                            <div style="position: absolute; left: -5000px;">
                                <input name="b_36c4fd991d266f23781ded980_aefe40901a" tabindex="-1" value="" type="text">
                            </div>

                        </form>
                    </div>

                </div>
            </div>
        </section>


        <!-- ================ Subscribe section end ================= -->

        <div id="myModal" class="modal">
            <div class="modal-content">
                <span class="close">&times;</span>
                <h2>Chọn sản phẩm</h2>
                <div class="row">
                    <input type="text" name="name" placeholder="Search" class="col-md-4">
                    <div class="col-md-6">


                    </div>


                </div>
            </div>
        </div>

        <script>
// Lấy phần tử modal
            var modal = document.getElementById("myModal");

// Lấy nút để mở modal
            var btn = document.getElementById("openModal");

// Lấy phần tử span để đóng modal
            var span = document.getElementsByClassName("close")[0];

// Khi người dùng nhấn vào nút, mở modal
            btn.onclick = function () {
                modal.style.display = "block";
            }

// Khi người dùng nhấn vào <span> (x), đóng modal
            span.onclick = function () {
                modal.style.display = "none";
            }

// Khi người dùng nhấn bên ngoài modal, đóng modal
            window.onclick = function (event) {
                if (event.target == modal) {
                    modal.style.display = "none";
                }
            }
        </script>


        <style>
            /* Mã CSS cho Modal */

            /* Ẩn modal theo mặc định */
            .modal {
                display: none;
                position: fixed;
                z-index: 1;
                left: 0;
                top: 0;
                width: 100%;
                height: 100%;
                background-color: rgba(0, 0, 0, 0.4); /* Màu nền trong suốt */
            }

            /* Nội dung của modal */
            .modal-content {
                background-color: #fff;
                margin: 5% auto; /* Căn giữa theo chiều dọc */
                padding: 20px;
                border: 1px solid #888;
                width: 50vw; /* Thu hẹp chiều rộng thành 60% */
                height: 70vh; /* Chiều cao chiếm 70% chiều cao màn hình */
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
                border-radius: 10px; /* Bo góc */
                overflow-y: auto; /* Tự động cuộn nếu nội dung vượt quá khung */
            }

            /* Nút đóng modal */
            .close {
                color: #aaa;
                float: right;
                font-size: 28px;
                font-weight: bold;
                cursor: pointer;
            }

            .close:hover,
            .close:focus {
                color: black;
            }

        </style>



        <!--================ Start footer Area  =================-->	
        <%@include file="footer.jsp" %>
        <!--================ End footer Area  =================-->
    </body>
</html>