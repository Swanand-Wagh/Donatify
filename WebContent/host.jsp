<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="ISO-8859-1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
    <link rel="stylesheet" href="./css/host.css">
    <title>Event Host</title>
  </head>

  <body style=" background-color:rgba(255,215,0,0.015)">
    <div class="host p-5">
      <h5 class="text-center mb-4 host-title">Host an <span class="text-warning" >event.</span></h5>

      <form action="EventServlet" method="post">
        <div class="form-group mb-3">
          <label>Event Name</label>
          <input style=" background-color:rgba(255,215,0,0.015)" class="form-control" type="text" name="name" required />
        </div>
        <div class="form-group mb-3">
          <select style=" background-color:rgba(255,215,0,0.015)" class="form-select" name="category">
            <option selected>Event Category</option>
            <option value="books">Books Donation</option>
            <option value="clothes">Clothes Donations</option>
          </select>
        </div>
        <div class="form-group mb-3">
          <label>Address</label>
          <input style=" background-color:rgba(255,215,0,0.015)" class="form-control" type="text" name="address" required />
        </div>
        <div class="row mb-3">
          <div class="col-6">
            <label>Start Day</label>
            <input style=" background-color:rgba(255,215,0,0.015)" class="form-control" type="date" name="startDate" required />
          </div>
          <div class="col-6">
            <label>End Day</label>
            <input style=" background-color:rgba(255,215,0,0.015)" class="form-control" type="date" name="endDate" required />
          </div>
        </div>
        <div class="row mb-3">
          <div class="col-6">
            <label>Start Time</label>
            <input style=" background-color:rgba(255,215,0,0.015)" class="form-control" type="time" name="startTime" required />
          </div>
          <div class="col-6">
            <label>End Time</label>
            <input style=" background-color:rgba(255,215,0,0.015)" class="form-control" type="time" name="endTime" required />
          </div>
        </div>
        <div class="col-lg-12 mb-2">
          <button class="btn btn-warning" type="submit" name="btnHost">Host Event</button>
        </div>
      </form>
    </div>

  </body>

  </html>