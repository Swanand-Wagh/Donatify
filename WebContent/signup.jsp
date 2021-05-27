<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="ISO-8859-1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous" />
    <link rel="stylesheet" href="./css/signup.css">
    <title>Sign Up</title>
    <!-- <link rel="stylesheet" href="./css/styles.css"> -->
  </head>

  <body style="background-color:rgba(255,215,0,0.010)">

    <div class="register-box px-5 pt-5 pb-4">
      <h5 class="text-center mb-5 register-title">Register <span class="text-warning" >yourself.</span> </h5>
      <form action="RegisterServlet" method="post">
        <div class="row form-group mb-2">
          <div class="col-4"><label>Select type : </label></div>
          <div class="col-8">
            <input style="margin-right:0.35rem;" class="type" type="radio" name="user-type" value="user" required
              checked>User
            <input style="margin-right:0.35rem;margin-left:0.5rem;" class="type" type="radio" name="user-type"
              value="ngo" required>NGO
          </div>
        </div>
        <div class="row form-group mb-2">
          <div class="col-4"><label>Name : </label></div>
          <div class="col-8"><input type="text" name="name" required /></div>
        </div>
        <div class="row form-group mb-2 field-license hide">
          <div class="col-4"><label>NGO license : </label></div>
          <div class="col-8"><input type="text" name="license" /></div>
        </div>
        <div class="row form-group mb-2">
          <div class="col-4"><label>Email : </label></div>
          <div class="col-8"><input type="email" name="username" required /></div>
        </div>
        <div class="row form-group mb-2">
          <div class="col-4"><label>Password : </label></div>
          <div class="col-8"><input type="password" name="password" required /></div>
        </div>
        <div class="row form-group mb-2">
          <div class="col-4"><label>Confirm Password : </label></div>
          <div class="col-8"><input type="password" name="cpassword" required /></div>
        </div>
        <div class="col-lg-12 mb-3">
          <button class="btn btn-warning" name="signup-submit" type="submit">Sign Up</button>
        </div>
        <div>
          Already have an account ? <a href="login.jsp">Click here</a>
        </div>
      </form>
    </div>

  </body>

  <script defer>
    const licenseDiv = document.querySelector('.field-license');
    const input = document.getElementsByName('user-type');

    input[0].addEventListener('click', () => {
      licenseDiv.classList.add("hide");
    });

    input[1].addEventListener('click', () => {
      licenseDiv.classList.remove("hide");
    });
  </script>

  </html>