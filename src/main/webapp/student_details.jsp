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
            width: 400px;
            background-color: white;
            text-align: center;
        }
        h2 {
            margin-bottom: 20px;
            color: palevioletred;
        }
        table {
        	
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        
        th{
        	
        	color:palevioletred;
        }
        th, td {
            padding: 10px;
            text-align: center;
        }
        .total{
        	font-weight:600;
        	color:palevioletred;
        }
    </style>
    
</head>
<body>

<div class="container">
    <h2>Prasanna School</h2>
    
    <p><strong>Student Name:</strong> <%= request.getAttribute("studentName") %></p>
    
    <br>

    <table>
        <tr>
            <th>Subject</th>
            <th>Marks</th>
        </tr>
        <tr>
            <td>English</td>
            <td><%= request.getAttribute("english") %></td>
        </tr>
        <tr>
            <td>Tamil</td>
            <td><%= request.getAttribute("tamil") %></td>
        </tr>
        <tr>
            <td>Maths</td>
            <td><%= request.getAttribute("maths") %></td>
        </tr>
        <tr>
            <td>Science</td>
            <td><%= request.getAttribute("science") %></td>
        </tr>
        <tr>
            <td>Social</td>
            <td><%= request.getAttribute("social") %></td>
        </tr>
        <tr>
            <td class="total">Total Mark</td>
            <td><%= request.getAttribute("total") %></td>
        </tr>
    </table>
    <br>
</div>


</body>
</html>