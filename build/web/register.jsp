<%-- 
    Document   : register.jsp
    Created on : May 26, 2023, 4:37:55 PM
    Author     : ACER NITRO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Resest Css -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
    <!-- nhúng font-chữ roboto vào -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./assets/fonts/themify-icons/themify-icons.css">
    <link rel="stylesheet" href="./assets/fonts/fontawesome-free-6.4.0-web/css/all.min.css">
    <link rel="stylesheet" href="./assets/css/base.css">
    <link rel="stylesheet" href="./assets/css/login.css">
    <link rel="stylesheet" href="./assets/css/register.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <!-- câu lệnh nếu trình duyệt nhỏ hơn IE 9 thì sẽ add thư viện hỗ trợ  vào -- bình thường thì không cần  -->
    <!--[if lt IE 9]>
     <script src="https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    <title>CornSalad Store</title>
</head>

<body>
    <!--header-->
    <div class="header-w3l">
        <h1>CornSalad Register Form</h1>
    </div>
    <!--//header-->
    <!-- main -->
    <div class="main-layout">
        <div class="main-form">
            <h2>Fill out the form below to Register</h2>
            <form action="RegisterServlet" method="post">
                <div class="form-sub-w3">
                    <input type="text" name="userName" placeholder="userName " required="">
                    <div class="icon-w3">
                        <i class="fa fa-user" aria-hidden="true"></i>
                    </div>
                </div>
                <div class="form-sub-w3">
                    <input type="email" name="email" placeholder="email " required="">
                    <div class="icon-w3">
                        
                        <i class="fa-solid fa-envelope" aria-hidden="true"></i>
                    </div>
                </div>
                <div class="form-sub-w3">
                    <input type="password" name="pass" placeholder="Password" required="">
                    <div class="icon-w3">
                        <i class="fa fa-unlock-alt" aria-hidden="true"></i>
                    </div>
                </div>
                <div class="form-sub-w3">
                    <input type="password" name="repeatPass" placeholder="Repeatpassword" required="">
                    <div class="icon-w3">
                        <i class="fa fa-unlock-alt" aria-hidden="true"></i>
                    </div>
                </div>
                <label class="anim">
                    <div class="anim-left">
                        <input type="checkbox" class="checkbox">
                        <span class="checkbox-span">I agree all statements in <a href="">Terms of service</a></span>
                    </div>
                    <a href="LoginServlet">Login</a>
                </label>
                <div class="clear"></div>
                <div class="submit-agileits">
                    <input type="submit" value="Register">
                </div>
            </form>

        </div>
    </div>
    <!-- fotter -->
    <div class="footer">
        <p>&copy; 2023 CornSalad Register Form. All rights reserved | Design by <a href="http://w3layouts.com">W3layouts</a>
        </p>
    </div>
</body>

</html>
