<%@ page language="java" import="model.*,service.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet"
	    integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous" />
	<title>Confirm Event </title>
</head>

<body style=" background-color:rgba(255,215,0,0.010)">
	<%
		int event_id = Integer.valueOf(request.getParameter("event_id"));
		Event event = EventService.getEventById(event_id);
		String type = request.getParameter("submit");
	%>
	<div style="width:fit-content;padding:2rem 5rem;margin-top:6rem ;box-shadow: -1px 4px 20px -6px rgba(0, 0, 0, 0.7)" class="container">
		<h4 class="mb-4">Event <span class="text-warning" >info.</span></h4>
		
		<div class="d-flex">
			<div class="card event mb-4" style="width: 18rem; margin-right: 2rem;box-shadow: -1px 4px 20px -6px rgba(0, 0, 0, 0.7)">
			<img class="card-img-top" src="./img.png" alt="Card image cap" />
			<div class="card-body">
		        <h5 class="card-title"><%= event.getName()%></h5>
		        <p class="card-text">
		        <div class="row">
		            <div class="col-4 h6">Category</div>
		            <div class="col-8 h6"><%= event.getCategory()%></div>
		            <div class="col-4 h6">Location</div>
		            <div class="col-8 h6"><%= event.getAddress()%></div>
		            <div class="col-4 h6">Date</div>
		            <div style="font-size:14px;padding-right:0" class="col-8 h6">
		                <%= event.getStartDate()%> to <%= event.getEndDate()%>
		            </div>
		            <div class="col-4 h6">At Time</div>
		            <div style="font-size:14px;padding-right:0" class="col-8 h6">
		                <%= event.getStartTime()%> - <%= event.getEndTime()%>
		            </div>
		        </div>
		        <p class="h6" style="font-style:oblique">Hosted by -- <strong><%= event.getNGO()%></strong></p>
		    </div>
		</div>
		
		<div style="width: 27rem;height:fit-content; padding:1.5rem; box-shadow: -1px 4px 20px -6px rgba(0, 0, 0, 0.7)">
			<form method="post" action="EnrollServlet">
				<input class="form-control" type="hidden" name="event_id" value="<%= event_id%>" />
				<input class="form-control" type="hidden" name="type" value="<%= type%>" />
				<div class="form-group mb-2">
					<label>Enter your Email</label>
					<input class="form-control" type="email" name="email" />
				</div>
				<%
				 	if(type.equals("home")){
				%>
				<div class="form-group mb-2">
					<label>Enter your Home Address</label>
					<input class="form-control" type="text" name="address" />
				</div>
				<label>Enter your time preference</label>
				<div class="row form-group mb-3">
					<div class="col-6"><input class="form-control" type="time" name="startTime" /></div>
					<div class="col-6"><input class="form-control" type="time" name="endTime" /></div>
				</div>
				<%
					}
				%>
				<button class="btn btn-warning mt-2" type="submit">Confirm Event</button>
			</form>	
		</div>
		</div>
		
	</div>
</body>
</html>