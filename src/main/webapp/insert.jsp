<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

    body{
        
        padding: 50px;
        background-image: linear-gradient(palevioletred, white);
        background-repeat: no-repeat;
        margin: 0;
        height: 100vh;
        
    }

    p {
            color: white;
            text-align: center;
            font-size: 26px;
            margin: 0 0 20px 0;
        }

        .container {
            border-radius: 20px;
            margin-left: 300px;
            padding: 50px;
            width:450px;
            border: 1.5px solid white;
        }

        label {
            font-size: 18px;
            margin-left: 80px;
            display: block;
            margin-bottom: 5px;
            color: white;
        }

        input {
            display: block;
            margin: 0 auto 20px auto;
            padding: 10px;
            width: 100%;
            border-radius: 15px;
            max-width: 300px;
            box-sizing: border-box;
            font-size: 18px;
            border-color: white;
        }

        button {
            height: 38px;
            font-size: 18px;
            padding: 10px 20px;
            background-color: palevioletred;
            border: none;
            font-family:Verdana, Geneva, Tahoma, sans-serif;
            color: white;
            cursor: pointer;
            transition: background-color 0.3s ease;
            margin-left: 180px;
            border-radius: 5px;
        }

        button:hover {
            background-color: #d4768a;
        }
</style>

</head>


<body>

 <div class="container">
        <p>Prasanna School</p>
        <br>
        <form action="insertdetails" method ="POST">
            <div>
                <label>Roll Number</label>
                <input id="roll" class="input" type="text" name="roll">
            </div>

            <div>
                <label>User Name</label>
                <input id="password" type="text" class="input" name="user_name">
            </div>
            <br>
            <button type="submit">Log in</button>
        </form>
    </div>

	<form action="show_details">
	<button type="submit">
	Student Details
	</button>
	
	</form>

</body>
</html>