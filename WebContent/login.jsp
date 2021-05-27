<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="ISO-8859-1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous" />
    <link rel="stylesheet" href="./css/login.css" />
    <title>Login</title>
  </head>

  <body style=" background-color:rgba(255,215,0,0.010)">
    <!-- ###################### LOGIN ###################### -->
    <div class="login-box">
      <div class="login-title">Welcome to <span class="text-warning" >donatify.</span> </div>
      <div class="col-lg-7 login-form">
        <div class="col-lg-12 login-form">
          <form action="LoginServlet" method="post">
            <div class="form-group">
              <label>Email</label> <br />
              <input style="background-color:rgba(255,215,0,0.010)" type="email" name="username" required />
            </div>
            <div class="form-group">
              <label>Password</label> <br />
              <input style="background-color:rgba(255,215,0,0.010)" type="password" name="password" required />
            </div>
            <div class="col-lg-12 mb-2">
              <button class="btn btn-warning" name="login-submit" type="submit">Login </button>
            </div>
            <div>Do not have an account ? <a class="text-decoration-none" href="signup.jsp">Click here</a></div>
          </form>
        </div>
      </div>
    </div>

  </body>

  </html>