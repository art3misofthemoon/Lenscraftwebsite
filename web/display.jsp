<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Eyewear Website</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">
        <style>
            h1 {
                font-family: "Pacifico", cursive;
                font-weight: 400;
                font-style: normal;
            }

            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-image: url(pastel.jpg);
                background-repeat: no-repeat;
                background-size: cover;
                background-position: center;
                display: flex;
                justify-content: center;
                align-items: center;
                min-height: 100vh;
            }

            header {
                height: 90px;
                position: fixed;
                top: 0;
                left: 0;
                right: 0;
                background-color: #f8f3e8;
                display: flex;
                justify-content: space-between;
                align-items: center;
                padding: 0 2rem;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            }

            nav {
                padding: 10px;
                margin-top: 20px;
            }

            nav a {
                color: #333;
                text-decoration: none;
                padding: 8px 12px;
                margin-right: 10px;
                border-radius: 5px;
                transition: background-color 0.3s ease;
            }

            nav a:hover {
                background-color: #e5d3b3;
            }

            section {
                padding: 20px;
                text-align: center;
                margin-top: 120px;
            }

            footer {
                background-color: plum;
                color: beige;
                padding: 10px;
                text-align: center;
                position: fixed;
                bottom: 0;
                left: 0;
                right: 0;
                border-radius: 10px;
                box-shadow: 0 -2px 5px rgba(0, 0, 0, 0.1);
            }
            .logo {
                max-width: 200px;
                margin-left: 20px;
                height: 90px;
                border-radius: 0px;
            }
            .search{
                --padding: 14px;
                width: max-content;
                display: flex;
                align-items: center;
                padding: var(--padding);
                border-radius: 28px;
                background-color: #f6f6f6;
                position: fixed;
                top: 350px;
                left: 530px;
            }
            .search-input{
                font-size: 16px;
                font-family: 'Lexend', sans-serif;
                color:#333333;
                margin-left: var(--padding);
                outline: none;
                border: none;
                background: transparent;
                width: 300px;
            }

            .login-btn {
                background-color: #FDADC2;
                border: none;
                color: white;
                padding: 10px 20px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                margin: 4px 2px;
                transition-duration: 0.4s;
                cursor: pointer;
                border-radius: 8px;
            }

            .login-btn:hover {
                background-color: #FF8C9E;
            }
            .carousel-container {
                width: 80%;
                margin: auto;
                overflow: hidden;
                margin-top: 400px;
            }

            .carousel {
                display: flex;
                transition: transform 1s ease-in-out;
            }

            .card {
                width: 300px;
                margin: 0 10px;
                border-radius: 10px;
                overflow: hidden;
            }

            .card img {
                width: 100%;
                height: auto;
                border-radius: 10px;
            }
        </style>
    </head>
    <body>
        <header>
            <img src="lenscraftlogo.jpg" alt="Logo" class="logo">
            <h1>Welcome to LensCraft!</h1>
            <nav>
                <a href="display.jsp">Home</a>
                <a href="http://localhost/HelloWorld/about.php">About</a>
                <a href="contact.html"> Contact Us </a>
                <button class="login-btn" onclick="redirectToLogin()">Login</button>
            </nav>
        </header>
        <div class="carousel-container">
            <div class="carousel">
                <div class="card">
                    <img src="img1.jpg" alt="Image 1">
                </div>
                <div class="card">
                    <img src="img2.jpg" alt="Image 2">
                </div>
                <div class="card">
                    <img src="img4.jpg" alt="Image 3">
                </div>
                <div class="card">
                    <img src="img5.jpg" alt="Image 4">
                </div>
                <div class="card">
                    <img src="img6.jpg" alt="Image 5">
                </div>
            </div>
        </div>
        <%@include file="search.html" %>
        <script>
            function redirectToLogin() {
                window.location.href = "firstpage.html";
            }
        </script>
    </body>
</html>

