<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background-image: linear-gradient(palevioletred, white);
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
        width: 400px;
        background: white;
        text-align: center;
    }
    h2 {
        margin-bottom: 20px;
        color: #333;
    }
    input {
        
        padding: 10px;
        margin: 5px 3px;
        border: 1px solid #ddd;
        border-radius: 4px;
    }
    button {
        width: 50%;
        padding: 10px;
        background-color: palevioletred;
        color: #fff;
        border: none;
        border-radius: 4px;
        font-size: 16px;
        cursor: pointer;
        transition: background-color 0.3s, transform 0.3s, box-shadow 0.3s;
    }
    button:hover {
        background-color: #d36e6e;
        transform: scale(1.05);
        box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
    }
    .social{
    	margin-right:200px;
    }
    
</style>

</head>

<body>

<div class="container">
    <h2>Add New Student</h2>
    <form action="add_student" method="POST">
        <input type="text" name="student_name" placeholder="Name" required />
        <input type="text" name="roll_no" placeholder="Roll Number" required />
        <input type="text" name="english" placeholder="English Marks" required />
        <input type="text" name="tamil" placeholder="Tamil Marks" required />
        <input type="text" name="maths" placeholder="Maths Marks" required />
        <input type="text" name="science" placeholder="Science Marks" required />
        <input class="social" type="text" name="social" placeholder="Social Marks" required />
        <br>
        <br>
        <button type="submit"> Submit </button>
    </form>
</div>

</body>
</html>