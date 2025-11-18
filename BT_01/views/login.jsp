<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #4e54c8, #8f94fb);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .login-box {
            width: 380px;
            background: rgba(255,255,255,0.95);
            backdrop-filter: blur(12px);
            padding: 35px 40px;
            border-radius: 14px;
            box-shadow: 0 10px 30px rgba(0,0,0,0.2);
            animation: fadeIn 0.6s ease;
        }

        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(20px); }
            to { opacity: 1; transform: translateY(0); }
        }

        h2 {
            text-align: center;
            margin-bottom: 25px;
            color: #333;
            font-weight: 600;
        }

        .input-group {
            position: relative;
            margin-bottom: 20px;
        }

        .input-group label {
            display: block;
            margin-bottom: 6px;
            color: #333;
            font-weight: 500;
        }

        .input-group input {
            width: 100%;
            padding: 12px 15px;
            border-radius: 8px;
            border: 1px solid #ccc;
            font-size: 15px;
            outline: none;
            transition: 0.3s;
        }

        .input-group input:focus {
            border-color: #4e54c8;
            box-shadow: 0 0 6px rgba(78, 84, 200, 0.4);
        }

        button {
            width: 100%;
            padding: 12px;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            font-weight: 500;
            cursor: pointer;
            transition: 0.3s;
        }

        .btn-login {
            background: #4e54c8;
            color: white;
        }

        .btn-login:hover {
            background: #3b41a1;
            transform: translateY(-2px);
            box-shadow: 0 4px 12px rgba(0,0,0,0.15);
        }

        .btn-register {
            background: #8f94fb;
            color: white;
            margin-top: 10px;
        }

        .btn-register:hover {
            background: #6f78e5;
        }

        .options {
            margin-top: 12px;
            display: flex;
            justify-content: space-between;
            font-size: 14px;
        }

        .options a {
            color: #4e54c8;
            text-decoration: none;
        }

        .alert {
            background: #ffdddd;
            border-left: 6px solid #f44336;
            padding: 12px;
            margin-bottom: 15px;
            border-radius: 8px;
            color: #a94442;
            font-size: 14px;
            animation: fadeIn 0.5s ease-in-out;
        }

        @media (max-width: 420px) {
            .login-box {
                width: 90%;
                padding: 25px;
            }
        }
    </style>
</head>
<body>
    <div class="login-box">

        <c:if test="${alert != null}">
            <div class="alert">${alert}</div>
        </c:if>

        <h2>Welcome Back</h2>
        
        <form action="${pageContext.request.contextPath}/login" method="post">

            <div class="input-group">
                <label for="uname">Username</label>
                <input type="text" id="uname" name="uname" placeholder="Enter Username" required>
            </div>

            <div class="input-group">
                <label for="psw">Password</label>
                <input type="password" id="psw" name="psw" placeholder="Enter Password" required>
            </div>

            <button type="submit" class="btn-login">Login</button>

            <div class="options">
                <label><input type="checkbox" name="remember" checked> Remember me</label>
                <a href="#">Forgot password?</a>
            </div>

            <button type="button" class="btn-register" onclick="window.location='${pageContext.request.contextPath}/signup'">Register</button>

        </form>
    </div>
</body>
</html>
