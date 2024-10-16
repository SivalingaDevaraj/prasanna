
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="prasanna.Student" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rank</title>

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
        width: 600px;
        background: white;
    }
    
    h2 {
        margin-bottom: 20px;
        color: #333;
        text-align: center;
    }
    
    table {
        width: 100%;
        border-collapse: collapse;
    }
    
    th, td {
        padding: 10px;
        border: 1px solid #ddd;
        text-align: left;
    }
    
    th {
        background-color: palevioletred;
        color: white;
    }
    
</style>

</head>
<body>

<div class="container">
    <h2>Students Rank</h2>
    <table>
        <thead>
            <tr>
                <th>Rank</th>
                <th>Name</th>
                <th>Roll Number</th>
                <th>Total Marks</th>
            </tr>
        </thead>
        <tbody>
            <% 
                List<Student> students = (List<Student>) request.getAttribute("ranked_students");
                int index = 1;
                for (Student student : students) { 
            %>
            <tr>
                <td><%= index++ %></td>
                <td><%= student.getStudent_name() %></td>
                <td><%= student.getRoll_number() %></td>
                <td><%= student.getTotal_mark() %></td>
            </tr>
            <% } %>
        </tbody>
    </table>
    
</div>

</body>
</html>