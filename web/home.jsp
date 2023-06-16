<%-- 
    Document   : home
    Created on : May 5, 2023, 7:19:37?PM
    Author     : ACER NITRO
--%>
<%@include file="./inc/header.jsp"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<div id=app__container"">
    <div class="top-arrival container">
        <!-- top new arrivals -->
        <div class="row">
            <h1 class="heading-title">Top New Arrivals</h1>
        </div>
        <!-- heading product -->
        <div class="heading-bar">
            <span class="heading-desc">
                Browse the collection of our best selling and top interesting products.
            </span>
            <ul class="heading-list">
                <li class="heading-item">
                    <span class="heading-text heading-text-color"> New arrivals</span>
                </li>
                <li class="heading-item">
                    <span class="heading-text"> Featured </span>
                </li>
            </ul>
        </div>
        <!-- top new product -->
        <div class="row">
            <c:forEach items="${productList}" var="product">
                <div class="col-md-3 col-sm-6 col-sx-12">
                    <div class="product-item">
                        <div class="product-image-wrap">
                            <a href="ProductDetailServlet?productId=${product.id}" class="product-image-wrap-link">
                                <img src="${product.thumbnail}" alt="" class="product-image">
                            </a>
                            <ul class="product-icon">
                                <li> <a href="ProductDetailServlet?productId=${product.id}"><i class="fa-regular fa-eye"></i></a></li>
                                <li> <a href="CartServlet"><i class="fa-solid fa-cart-shopping"></i></a></li>
                                <li> <a href=""><i class="fa-solid fa-arrows-rotate"></i></a></li>
                                <li> <a href=""><i class="fa-regular fa-heart"></i></a></li>
                            </ul>
                        </div>
                        <form class="product-footer" action="CartServlet" method="post">
                            <input type="hidden" name="action" value="create"/>
                            <input type="hidden" name="quantity" value="1"  min="1" />
                            <input type="hidden" name="productId" value="${product.id}"/>
                            <input type="hidden" name="productPrice" value="${product.price}"/>
                            <span class="product-short-desc">${product.description}</span>
                            <h1 class="product-title">${product.name}</h1>
                            <div class="product-price">
                                <span class="product-price-1">
                                    <fmt:setLocale value = "en_US"/>
                                    <fmt:formatNumber type="currency" value = "${product.price}" /> 
                                </span>
                            </div>
                            <button type="submit" class="_btn _btn-product">Add to cart</button>
                        </form>

                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="element-margin">
            <div class="row ">
                <div class="col-md-3">
                    <div class="elementor-container">
                        <img src="./assets/img/delivery-1.png" alt="" class="elementor-container-img">
                        <span class="elementor-container-text">
                            <strong>Free delivery</strong> from 100$
                        </span>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="elementor-container">
                        <img src="./assets/img/support-1.png" alt="" class="elementor-container-img">
                        <span class="elementor-container-text">
                            <strong>24H Support</strong> center
                        </span>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="elementor-container">
                        <img src="./assets/img/save-2.png" alt="" class="elementor-container-img">
                        <span class="elementor-container-text">
                            <strong>Saving</strong> your money
                        </span>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="elementor-container">
                        <img src="./assets/img/quality-2.png" alt="" class="elementor-container-img">
                        <span class="elementor-container-text">
                            <strong>Best Quality</strong> materials
                        </span>
                    </div>
                </div>
            </div>
        </div>
        <div class="container-phantom">
            <div class="row">
                <div class="col-md-6">
                    <div class="container-phantom-content">
                        <img src="./assets/img/71.jpg" alt="" class="container-phantom-img">
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="container-phantom-right">
                        <div class="container-phantom-up">
                            <h1 class="container-phantom-heading">DJL Phantom 3 Standard RTF Kit</h1>
                            <span class="container-phantom-text">Lorem ipsum dolor sit amet consectetur
                                adipisicing elit.</span>
                            <button class="phantom-btn">BUY NOW</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="featured">
            <div class="row">
                <!-- heading product -->
                <h1 class="heading-title">Featured Categories</h1>
                <span class="heading-desc">
                    Variety of product categories, tens of products, only five-stars reviews.
                </span>
            </div>
            <!-- top Featured Categories -->
            <div class="row">
                <c:forEach items="${hotcategoryList}" var="category">
                    <div class="col-md-3">
                        <div class="Featured-categories">
                            <a href="CategoryServlet?categoryId=${category.id}">
                                <img src="${category.thumbnail}" alt="" class="Featured-categories-img">
                            </a>
                            <ul class="Featured-categories-list">
                                <li class="Featured-categories-item ">
                                    <a href="CategoryServlet?categoryId=${category.id}" class="Featured-categories-link Featured-categories-link-first">${category.name}</a>
                                </li>
                                <li class="Featured-categories-item">
                                    <a href="" class="Featured-categories-link">Radar Detectors (2)</a>
                                </li>
                                <li class="Featured-categories-item">
                                    <a href="" class="Featured-categories-link">Car Electrical Appliances (4)</a>
                                </li>
                                <li class="Featured-categories-item">
                                    <a href="" class="Featured-categories-link">Car Camera (4)</a>
                                </li>
                                <li class="Featured-categories-item">
                                    <a href="" class="Featured-categories-link">Audio (2)</a>
                                </li>
                                <li class="Featured-categories-item">
                                    <a href=""
                                       class="Featured-categories-link Featured-categories-link-last">ViewAll</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div class="exolens">
            <div class="row">
                <!-- heading product -->
                <h1 class="heading-title">Hot Products</h1>
                <span class="heading-desc">
                    Browse the collection of our best selling and top interesting products. Eye Catching Electronics Demo
                </span>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div class="row">
                        <c:forEach items="${hotProductList}" var="product">
                            <div class="col-md-6">
                                <div class="product-item">
                                    <div class="product-image-wrap">
                                        <a href="ProductDetailServlet?productId=${product.id}" class="product-image-wrap-link">
                                            <img src="${product.thumbnail}" alt="" class="product-image">
                                        </a>
                                        <ul class="product-icon">
                                            <li> <a href=""><i class="fa-regular fa-eye"></i></a></li>
                                            <li> <a href=""><i class="fa-solid fa-cart-shopping"></i></a></li>
                                            <li> <a href=""><i class="fa-solid fa-arrows-rotate"></i></a></li>
                                            <li> <a href=""><i class="fa-regular fa-heart"></i></a></li>
                                        </ul>
                                    </div>
                                    <form class="product-footer" action="CartServlet" method="post">
                                        <input type="hidden" name="action" value="create"/>
                                        <input type="hidden" name="quantity" value="1"  min="1" />
                                        <input type="hidden" name="productId" value="${product.id}"/>
                                        <input type="hidden" name="productPrice" value="${product.price}"/>
                                        <span class="product-short-desc">${product.description}</span>
                                        <h1 class="product-title">${product.name}</h1>
                                        <div class="product-price">
                                            <span class="product-price-1">
                                                <fmt:setLocale value = "en_US"/>
                                                <fmt:formatNumber type="currency" value = "${product.price}" /> 
                                            </span>
                                        </div>
                                        <button type="submit" class="_btn _btn-product">Add to cart</button>
                                    </form>

                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="featured-optics">
                        <div class="featured-optics-by">
                            <h1 class="featured-optics-heading">ExoLens With Optics By ZEISS</h1>
                            <img src="./assets/img/61-ow6mduo0nkuqzz4o45c6sxla171l1dmztxikyq0z34.jpg" alt=""
                                 class="featured-optics-img">
                            <button class="featured-optics-btn">Buy now</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="latest">
            <div class="row">
                <!-- heading product -->
                <h1 class="heading-title">Latest Posts</h1>
                <span class="heading-desc"> Present posts in a best way to highlight interesting moments of your
                    blog.</span>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <div class="latest-container">
                        <div class="lastest-general">
                            <span class="lastest-general-text">General</span>
                        </div>
                        <div class="latest-wrap-img">
                            <a href="#" class="latest-wrap-img-link">
                                <img src="./assets/img/5.jpg" alt="" class="latest-img">
                            </a>
                        </div>

                        <div class="lastest-body">
                            <div class="latest-header">
                                <a href="" class="latest-link">
                                    <h3 class="latest-heading">Dapibus Etiam Tellus</h3>
                                </a>
                                <span class="latest-date"> <i
                                        class=" latest-date-icon fa-solid fa-calendar-days"></i>
                                    October 30, 2016 <i class="latest-date-icon fa-solid fa-message"></i>
                                    0</span>
                            </div>
                            <span class="latest-content">
                                Gravida feugiat nascetur adipiscing metus dolor a cum class curae cum
                                consectetur vel in ut phasellus commodo vestibulum adipiscing nam fringilla
                                scelerisque. Adipiscing odio ullamcorper... </span>
                            <a href="" class="latest-continue">Continue reading</a>
                        </div>

                    </div>
                </div>
                <div class="col-md-4">
                    <div class="latest-container">
                        <div class="lastest-general">
                            <span class="lastest-general-text">General</span>
                        </div>
                        <div class="latest-wrap-img">
                            <a href="" class="latest-wrap-img-link">
                                <img src="./assets/img/10.jpg" alt="" class="latest-img">
                            </a>
                        </div>

                        <div class="lastest-body">
                            <div class="latest-header">
                                <a href="" class="latest-link">
                                    <h3 class="latest-heading">Etiam tellus</h3>
                                </a>
                                <span class="latest-date"> <i
                                        class=" latest-date-icon fa-solid fa-calendar-days"></i>
                                    October 19, 2016 <i class="latest-date-icon fa-solid fa-message"></i>
                                    0</span>
                            </div>
                            <span class="latest-content">
                                Gravida feugiat nascetur adipiscing metus dolor a cum class curae cum
                                consectetur vel in ut phasellus commodo vestibulum adipiscing nam fringilla
                                scelerisque. Adipiscing odio ullamcorper... </span>
                            <a href="" class="latest-continue">Continue reading</a>
                        </div>

                    </div>
                </div>
                <div class="col-md-4">
                    <div class="latest-container">
                        <div class="lastest-general">
                            <span class="lastest-general-text">General</span>
                        </div>
                        <div class="latest-wrap-img">
                            <a href="" class="latest-wrap-img-link">
                                <img src="./assets/img/14.jpg" alt="" class="latest-img">
                            </a>
                        </div>

                        <div class="lastest-body">
                            <div class="latest-header">
                                <a href="" class="latest-link">
                                    <h3 class="latest-heading">Consectetur</h3>
                                </a>
                                <span class="latest-date"> <i
                                        class=" latest-date-icon fa-solid fa-calendar-days"></i>
                                    October 19, 2016 <i class="latest-date-icon fa-solid fa-message"></i>
                                    0</span>
                            </div>
                            <span class="latest-content">
                                Lorem ipsum donec mattis mi congue non pellentesque luctus, sociosqu justo id
                                ultrices sapien aliquet curabitur iaculis, ullamcorper malesuada neque auctor
                                nunc tortor vestibulum non... </span>
                            <a href="" class="latest-continue">Continue reading</a>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <div class="cover">
            <div class="logo">
                <img src="./assets/img/logo-1-1.png" alt="" class="logo-item--img">
                <img src="./assets/img/logo-3.png" alt="" class="logo-item--img">
                <img src="./assets/img/logo-2.png" alt="" class="logo-item--img">
                <img src="./assets/img/logo-1.png" alt="" class="logo-item--img">
                <img src="./assets/img/logo-4.png" alt="" class="logo-item--img">
            </div>
            <div class="subscribe">
                <div class="img-container">
                    <h2 class="img-container-heading">Subscribe to our newsletter!</h2>
                    <form action="" class="img-container-content">
                        <input type="text" name="" id="" class="img-container-input"
                               placeholder="Your email address" required>
                        <input type="submit" class="img-container-btn" value="SIGN UP">
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%@include file="./inc/footer.jsp"%>