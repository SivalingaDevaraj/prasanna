<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="prasanna.StudentAverage" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Average Marks</title>

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
        width: 400px;
        text-align: center;
    }
    
    h2 {
        margin-bottom: 20px;
        color: black;
    }

    table {
        width: 100%;
        border-collapse: collapse;
    }
    
    th, td {
        padding: 10px;
        text-align: left;
    }

    th {
        background-color: palevioletred;
        color: white;
        font-size: 18px;
        font-weight: bold;
    }

    td {
        background-color: #f9f9f9;
        font-size: 16px;
    }

    tr:nth-child(even) td {
        background-color: #f2f2f2;
    }

    tr:hover td {
        background-color: #eaeaea;
    }
</style>

</head>
<body>

<div class="container">
    <h2>Average Marks</h2>
    <br>
    <table>
        <thead>
            <tr>
                <th>Student Name</th>
                <th>Average Marks</th>
            </tr>
        </thead>
        <tbody>
            <% 
                List<StudentAverage> averages = (List<StudentAverage>) request.getAttribute("averages");
                if (averages != null) {
                    for (StudentAverage avg : averages) {
            %>
                <tr>
                    <td><%= avg.getStudent_name() %></td>
                    <td><%= avg.getAverage_mark() %></td>
                </tr>
            <% 
                    }
                } 
            %>
        </tbody>
    </table>
    <br>
</div>

</body>
</html>