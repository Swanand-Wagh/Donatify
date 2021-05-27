<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="ISO-8859-1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet" />
    <link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
    <title>DONATIFY </title>
  </head>

  <body style=" background-color:rgba(255,215,0,0.035)">
    <!-- ###################### NAVBAR ###################### -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark donatify-nav">
      <div class="container">
        <a class="navbar-brand text-warning" href="#"><i style="font-size: 24px" class="fas fa-hand-holding-heart"></i>
          Donatify</a>
        <div class="collapse navbar-collapse d-flex justify-content-end" id="navbarSupportedContent">
          <ul class="navbar-nav mb-2 mb-lg-0">
            <li style="margin-right: 2rem" class="nav-item">
              <a class="nav-link" href="login.jsp">Login</a>
            </li>
            <li style="margin-right: 2rem" class="nav-item">
              <a class="nav-link" href="signup.jsp">Sign Up</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <div style="padding-top: 5.5rem;padding-bottom:3rem" class="jumbotron jumbotron-fluid container">
      <h3 style="color:black;font-size: 63px; font-weight: 600;" class="mb-5">
        <span>Donation
        made easy with</span> <br> <span class="text-warning">donatify.</span> 
      </h3>

      <p style="color:black;" class="h5">
        Donatify is a simple web based platform where <br> you can easily donate
        towards the betterment of the society.
      </p>
    </div>
    <div class="container my-5">
      <div class="row">
        <div class="col-sm-1"></div>
        <div class="col-sm-5">
          <div style="box-shadow: -1px 4px 20px -6px rgba(0, 0, 0, 0.7);" class="card">
            <div class="card-header">
              <h5 class="card-title">What you get as an <span class="text-warning" style="font-weight:bolder;">NGO</span></h5>
            </div>
            <div class="card-body">
              <p class="card-text h6">
                1. Host an Event with choices namely Books & Clothes.
              </p>
              <p class="card-text h6 mb-3">
                2. View all the people who have registered for an event
              </p>
              <a href="signup.jsp" class="btn btn-warning">Interested</a>
            </div>
          </div>
        </div>
        <div class="col-sm-5">
          <div style="box-shadow: -1px 4px 20px -6px rgba(0, 0, 0, 0.7);" class="card">
            <div class="card-header">
              <h5 class="card-title">What you get as a <span class="text-warning" style="font-weight:bolder;">volunteer</span> </h5>
            </div>
            <div class="card-body">
              <p class="card-text h6">
                1. View all the Events that are happening.
              </p>
              <p class="card-text h6 mb-3">
                2. Contribute to an Event by being a valuable Donor.
              </p>
              <a href="signup.jsp" class="btn btn-warning">Interested</a>
            </div>
          </div>
        </div>
        <div class="col-sm-1"></div>
      </div>

      <!-- ################################ PAST EVENTS ############################# -->
      <div class="row my-5">
        <h3 class="mb-4">Past Conducted Events</h3>
        <div class="col-3">
          <div class="card" style="
              width: 18rem;
              box-shadow: -1px 4px 20px -6px rgba(0, 0, 0, 0.7);
            ">
            <img class="card-img-top" src="./donatify.svg" alt="Card image cap" />
            <div class="card-body">
              <h5 class="card-title">Book Donation</h5>
              <p class="card-text">
                Some quick example text to build on the card title and make up
                the bulk of the card's content.
              </p>
            </div>
          </div>
        </div>
        <div class="col-3">
          <div class="card" style="
              width: 18rem;
              box-shadow: -1px 4px 20px -6px rgba(0, 0, 0, 0.7);
            ">
            <img class="card-img-top" src="./donatify.svg" alt="Card image cap" />
            <div class="card-body">
              <h5 class="card-title">Book Donation</h5>
              <p class="card-text">
                Some quick example text to build on the card title and make up
                the bulk of the card's content.
              </p>
            </div>
          </div>
        </div>
        <div class="col-3">
          <div class="card" style="
              width: 18rem;
              box-shadow: -1px 4px 20px -6px rgba(0, 0, 0, 0.7);
            ">
            <img class="card-img-top" src="./donatify.svg" alt="Card image cap" />
            <div class="card-body">
              <h5 class="card-title">Clothes Donation</h5>
              <p class="card-text">
                Some quick example text to build on the card title and make up
                the bulk of the card's content.
              </p>
            </div>
          </div>
        </div>
        <div class="col-3">
          <div class="card" style="
              width: 18rem;
              box-shadow: -1px 4px 20px -6px rgba(0, 0, 0, 0.7);
            ">
            <img class="card-img-top" src="./donatify.svg" alt="Card image cap" />
            <div class="card-body">
              <h5 class="card-title">Clothes Donation</h5>
              <p class="card-text">
                Some quick example text to build on the card title and make up
                the bulk of the card's content.
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- ################### FOOTER ######################-->
    <div class="card text-center bg-dark">
      <div class="card-body">
        <h5 class="card-title text-white">Copyrights</h5>
            <p class="card-text text-warning">@Donatify 2021</p>
      </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
      crossorigin="anonymous"></script>

  </body>

  </html>