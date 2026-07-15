<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        body{
            background-color: #61afc9;
            margin: 0;

        }
        form{
            background-color: #2ce032;
            color: black;
        }
    </style>
</head>
<body>
<h1>Serverlet App</h1>
<h3>Individual Form</h3>
<hr>
<form action="details" method="post">
    <label for="name">Name : </label>
    <input type="text" name="name" id="name" placeholder="enter name">

    <a href="/details"><button>Submit</button></a>
</form>
</body>
</html>