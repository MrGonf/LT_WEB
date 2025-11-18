<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Đăng ký tài khoản</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(135deg, #4e54c8, #8f94fb);
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .container {
        width: 420px;
        padding: 40px;
        background: rgba(255, 255, 255, 0.95);
        backdrop-filter: blur(12px);
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
        margin-bottom: 30px;
        color: #333;
        font-weight: 600;
    }

    .alert {
        background: #ffdddd;
        border-left: 6px solid #f44336;
        padding: 12px;
        margin-bottom: 20px;
        border-radius: 8px;
        color: #a94442;
        font-size: 14px;
        text-align: center;
        animation: fadeIn 0.5s ease-in-out;
    }

    input {
        width: 100%;
        padding: 12px 15px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 8px;
        font-size: 15px;
        outline: none;
        transition: 0.3s;
    }

    input:focus {
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
        margin-top: 10px;
    }

    .btn-register {
        background: #4e54c8;
        color: white;
    }

    .btn-register:hover {
        background: #3b41a1;
        transform: translateY(-2px);
        box-shadow: 0 4px 12px rgba(0,0,0,0.15);
    }

    .login-link {
        margin-top: 15px;
        text-align: center;
        font-size: 14px;
    }

    .login-link a {
        color: #4e54c8;
        text-decoration: none;
        font-weight: 500;
    }

    .login-link a:hover {
        text-decoration: underline;
    }

    form input::placeholder {
        color: #999;
    }

    @media (max-width: 450px) {
        .container {
            width: 90%;
            padding: 25px;
        }
    }
</style>
</head>
<body>

<div class="container">
    <h2>Đăng ký tài khoản</h2>

    <% 
        String alert = (String) request.getAttribute("alert");
        if (alert != null) {
    %>
        <div class="alert"><%= alert %></div>
    <% } %>

    <form action="${pageContext.request.contextPath}/signup" method="post">

        <input type="text" name="username" placeholder="Tài khoản" 
               value="<%= request.getParameter("username") != null ? request.getParameter("username") : "" %>" required>

        <input type="password" name="password" placeholder="Mật khẩu" required>

        <input type="text" name="fullname" placeholder="Họ và tên"
               value="<%= request.getParameter("fullname") != null ? request.getParameter("fullname") : "" %>" required>

        <input type="email" name="email" placeholder="Email"
               value="<%= request.getParameter("email") != null ? request.getParameter("email") : "" %>" required>

        <input type="text" name="phone" placeholder="Số điện thoại"
               value="<%= request.getParameter("phone") != null ? request.getParameter("phone") : "" %>" required>

        <button type="submit" class="btn-register">Đăng ký</button>
    </form>

    <div class="login-link">
        Đã có tài khoản? <a href="${pageContext.request.contextPath}/login">Đăng nhập</a>
    </div>
</div>

</body>
</html>
