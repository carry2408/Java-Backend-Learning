<!DOCTYPE html>
<html>
<head>
    <title>Servlet App</title>
</head>
<body>



<h2 style="text-align: center">Calculator Sum App</h2>

<form method="POST" action="add">
    <label>Number 1 : </label><br>
    <input type="number" name="num1" placeholder="Enter first number"><br><br>

    <label>Number 2 : </label><br>
    <input type="number" name="num2" placeholder="Enter second number"><br><br>

    <input type="submit" value="add">
</form>

<hr/>
<hr/>
<form action="redirect"  method="post">
    <label for="name">Name : </label>
    <input type="text" name="name" id="name" placeholder="enter name">
    <input type="submit"  value="redirect">
</form>

</body>
</html>