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
        width: 340px;
        text-align: center;
        background: white;
    }
    h2 {
        margin-bottom: 20px;
        color: #333;
    }
    .link{
        margin-right: 10px;
        margin-left:10px;
        display: block;
        padding: 10px;
        background-color: palevioletred;
        color:white;
        border: none;
        border-radius: 4px;
        font-size: 16px;
        text-align: center;
        text-decoration: none;
        margin-bottom: 10px;
        cursor: pointer;
        transition: background-color 0.3s, transform 0.3s, box-shadow 0.3s;
    }
    .link:hover {
        background-color: #d36e6e;
        transform: scale(1.05);
        box-shadow: 0 4px 15px rgba(0, 91, 187, 0.3);
    }
</style>


</head>
<body>

<div class="container">
    <h2>Admin Access</h2>
    <a href="show_details" class="link">Show All Student Details</a>
    <a href="add_new_student.jsp" class="link">Add New Student Detail</a>
    <a href="highest_mark" class="link">Highest Mark</a>
    <a href="student_rank" class="link">Students Rank</a>
    <a href="average_mark" class="link">Average Mark</a>
    <a href="delete_student.jsp" class="link">Delete a Student Detail</a>
</div>

</body>
</html>