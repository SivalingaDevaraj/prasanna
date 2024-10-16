<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="prasanna.details" %>

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
            width: 600px;
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
        
    </style>

</head>

<body>

<div class="container">

 <h2 style="text-align:center;">Student List</h2>
    <table>
        <tr>
            <th>Name </th>
            <th>Roll Number</th>
            <th>English</th>
            <th>Tamil</th>
            <th>Maths</th>
            <th>Science</th>
            <th>Social</th>
        </tr>

        <%
            List<details> DetailsRef = (List<details>) request.getAttribute("student_details");
            if (DetailsRef!= null) {
                for (details e : DetailsRef) {
        %>
                    <tr>
                        <td><%= e.getStudent_name() %></td>
                        <td><%= e.getRoll_number() %></td>
                        <td><%= e.getEnglish() %></td>
                        <td><%= e.getTamil() %></td>
                        <td><%= e.getMaths() %></td>
                        <td><%= e.getScience() %></td>
                        <td><%= e.getSocial() %></td>
                    </tr>
        <%
                }
            }
        %>
        
    </table>
    </div>
</body>

</body>
</html>