<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Student</title>
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
        
        input[type="text"] {
            padding: 10px;
            margin: 5px 0;
            width: 100%;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        
        input[type="submit"] {
            padding: 10px;
            background-color: palevioletred;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 80%;
        }
        
        input[type="submit"]:hover {
            background-color: #d36c6c;
        }
    </style>
</head>
<body>

<div class="container">

    <h2>Delete Student</h2>
    
    <form action="delete_student" method="post">
        <input type="text" name="name" placeholder="Student Name" required>
        <input type="text" name="roll_no" placeholder="Roll Number" required>
        <br>
        <br>
        <input type="submit" value="Delete Student">
    </form>
</div>

</body>
</html>