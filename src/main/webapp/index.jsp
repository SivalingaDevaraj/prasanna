<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prasanna School</title>

 <style>
 
        body {
            font-family: Arial, sans-serif;
            background-image: linear-gradient(palevioletred,white);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        
        .container {
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: center;
        }
        
        h2 {
            margin-bottom: 20px;
            color:white;
        }
   
        .login {
            width:180px;
            padding: 10px;
            background-color:palevioletred;
            color: #fff;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s, transform 0.3s, box-shadow 0.3s;
        }
        
        .login:hover {
            background-color:palevioletred;
            transform: scale(1.05);
            box-shadow: 0 4px 15px rgba(0, 91, 187, 0.3);
        }
        
    </style>

</head>
<body>

<div class="container">
		
        <br>
        <h2>Prasanna School</h2>
        <br>
        <form action ="admin_login.jsp">
        <button type="submit" class="login">Admin Login</button>
        </form>
        <br>
        <br>
        <form action="students_login.jsp">
        <button type="submit" class="login">Student Login</button>
        </form>
        <br>
        <br>
        
    </div>

</body>
</html>