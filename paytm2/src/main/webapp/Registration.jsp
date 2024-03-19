<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Registration Form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }

        .container {
            margin-top: 50px;
        }
    </style>
</head>
<body>
    <div class="container">
    <div class="row">
    <div class="col-6 mx-auto bg-primary p-4 rounded">
     <h2 class="text-center mb-4">Registration Form</h2>
        <form action="Registration" method="get"> 
            <div class="form-group">
                <label for="fullName">Full Name:</label>
                <input type="text" class="form-control" id="fullName" placeholder="Enter your full name" name="name">
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" placeholder="Enter your email" name="email">
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password" placeholder="Enter your password" name="password">
            </div>
            <div class="form-group">
                <label for="confirmPassword">Confirm Password:</label>
                <input type="password" class="form-control" id="confirmPassword" placeholder="Confirm your password" name="cpassword">
            </div>
            <div class="d-flex justify-content-between">
            <button type="submit" class="btn btn-success">Register</button>
            <div>
            <p>already have an account?<a href="Login.jsp" class="btn btn-secondary">Login</a></p>
            </div>
            </div>
        </form>
    </div>
    </div>
       
    </div>

     
</body>
</html>
