<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>

<style>
    body {
        font-family: 'Lora', serif;
        background-image: linear-gradient(palevioletred, white);
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    
    .container {
        background-color: white;
        padding: 30px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        width: 300px;
        text-align: center;
    }
    
    h2 {
        margin-bottom: 20px;
        color: black;
    }
    
    .message {
        font-size: 18px;
        color: palevioletred;
    }
</style>

</head>
<body>

<div class="container">
    <h2>Operation Result</h2>
    <p class="message">
        <%= request.getAttribute("message") %>
    </p>
</div>

</body>
</html>