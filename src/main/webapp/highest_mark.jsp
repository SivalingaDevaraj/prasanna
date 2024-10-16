<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Highest Marks</title>

<style>
    
    body {
            font-family: 'Lora', serif;
            background-image: linear-gradient(palevioletred,white);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        
        .container {
        	background-color:white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            width: 300px;
            text-align: center;
        }
        
        h2 {
            margin-bottom: 20px;
            color:black;
        }
    
    	.marks {
    		font-size: 19px;
    		font-weight:500;
    		color:white;
    		background-color:palevioletred;
    		padding: 10px;
    		margin-bottom: 10px;
    		margin-top:5px;
    		border-radius: 15px;
    		box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
    		font-family: 'Lora', serif;
}
    
</style>

</head>
<body>

<div class="container">
    <h2>Highest Marks</h2>
    
    <br>
    <div class="marks">English: ${maxEnglish}</div>
    <div class="marks">Tamil: ${maxTamil}</div>
    <div class="marks">Maths: ${maxMaths}</div>
    <div class="marks">Science: ${maxScience}</div>
    <div class="marks">Social: ${maxSocial}</div>
    <br>
</div>

</body>
</html>