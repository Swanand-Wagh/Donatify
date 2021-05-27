<%@ page language="java" import="model.*,service.*,java.util.*,java.sql.*,database.*,service.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet" />
<title>Ngo Dashboard</title>
</head>

<body style="background-color:rgba(255,215,0,0.035)">
	<%!
		Connection connect = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
	%>

	<%
		int user_id = (Integer)session.getAttribute("user_id");
		List<Event> events = EventService.getEventsOfUser(user_id);
	%>
	
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark donatify-nav">
        <div class="container">
            <a class="navbar-brand text-warning" href="#"><i style="font-size: 24px"
                    class="fas fa-hand-holding-heart"></i>
                Donatify</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse d-flex justify-content-end" id="navbarSupportedContent">
                <ul class="navbar-nav mb-2 mb-lg-0">
                    <li style="margin-right: 2rem" class="nav-item">
                        <a class="nav-link" href="#">Dashboard</a>
                    </li>
                    <li style="margin-right: 2rem" class="nav-item">
                        <a class="nav-link" href="host.jsp">Host Event</a>
                    </li>
                    <li style="margin-right: 2rem" class="nav-item">
                        <a class="nav-link" href="logout.jsp">Logout</a>
                    </li>
                    <li style="margin-right: 2rem" class="nav-item">
                        <a class="nav-link" href="#">Contact</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
	
	<div class="container mt-5 mb-4">
        <div style="box-shadow: -1px 4px 20px -6px rgba(0, 0, 0, 0.7);" class="card w-25">
            <div class="card-header">
                <h5 class="card-title">Your <span class="text-warning" >profile.</span></h5>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col-3">
                        <h6 class="card-text">Name</h6>
                        <h6 class="card-text">Email</h6>
                    </div>
                    <div class="col-9">
                        <h6 class="card-text"><%= session.getAttribute("name")%></h6>
                        <h6 class="card-text"><%= session.getAttribute("currUser")%></h6>
                    </div>
                </div>
            </div>
        </div>
    </div>
	
	<section class="container mt-5">
		<h4 class="mb-4">Your <span class="text-warning" >events.</span> </h4>
		<% 
			if(!events.isEmpty()){
		%>
		<div class="wrapper d-flex flex-wrap">
			<% 
				for(Event e:events){
			%>
				<div class="card event mb-4" style="width: 18rem; margin-right: 2rem;box-shadow: -1px 4px 20px -6px rgba(0, 0, 0, 0.7)">
				  <img class="card-img-top" src="./img.png" alt="Card image cap" />
				  <div class="card-body">
				    <div class="d-flex m-0 ">
				    	<h5 style="font-variant: capitalize;" class="card-title mb-0">
					      <%= e.getName()%>
					    </h5>
					    <form action="DeleteEvent">
					    	<input type="hidden" value="<%= e.getId()%>" name="id" />
					    	<input style="margin-left:4rem;padding:2px 10px" class="btn btn-danger" type="submit" value="Delete"/>
					    </form>
				    </div>
				    <p class="card-text">
				    <div class="row">
				      <div class="col-4 h6">Category</div>
				      <div class="col-8 h6">
				        <%= e.getCategory()%>
				      </div>
				      <div class="col-4 h6">Location</div>
				      <div class="col-8 h6">
				        <%= e.getAddress()%>
				      </div>
				      <div class="col-4 h6">Date</div>
				      <div style="font-size:14px;padding-right:0" class="col-8 h6">
				        <%= e.getStartDate()%> to <%= e.getEndDate()%>
				      </div>
				      <div class="col-4 h6">At Time</div>
				      <div style="font-size:14px;padding-right:0" class="col-8 h6">
				        <%= e.getStartTime()%> - <%= e.getEndTime()%>
				      </div>
				    </div>
				  </div>
				</div>
			<%
				}
			%>
		</div>
		<%
			}else{
		%>
				<h5>No Events added yet!</h5>
		<%
			}
		%>
	</section>
	
	<section class="container mt-4">
		<h4 class="mb-4">Your <span class="text-warning" >registrations.</span> </h4>
		<%
			connect = DatabaseAPI.connectToDatabase();
			pst = connect.prepareStatement("select user_id,event_id,type from enrollment where event_id in (select event_id from event where user_id = ? and end_date > CURDATE());");
			pst.setInt(1, user_id);
			rst = pst.executeQuery();
			if(!rst.next()){
		%>
				<h4 class="mb-4">No One Registered Yet</h4>
		<%	}else{
			%>
			<div class="d-flex">
			<%
				rst.previous();
				while(rst.next()){
		 %>	
				<div class="card" style="width: 18rem; margin-right: 2rem; box-shadow: -1px 4px 20px -6px rgba(0, 0, 0, 0.7);">
                <img class="card-img-top" src="./img.png" alt="Card image cap" />
                <div class="card-body">
                    <h5 style="font-variant: capitalize;" class="card-title mb-3 "><%= EventService.getEventById(rst.getInt(2)).getName()%></h5>
                    <div class="row">
                        <div class="col-4">
                            <h6 class="card-text ">Name</h6>
                            <h6 class="card-text ">Email</h6>
                            <h6 class="card-text ">Choice</h6>
                        </div>
                        <div class="col-8">
                            <h6 class="card-text "><%= UserService.getNameById(rst.getInt(1))%></h6>
                            <h6 class="card-text "><%= UserService.getUserById(rst.getInt(1)).getUsername()%></h6>
                            <h6 class="card-text "><%= rst.getString(3)%></h6>
                        </div>
                    </div>
                </div>
            </div>
		<%	
			}
		%>
		</div>
		<%
		}
		%>
	</section>
	
	<!-- ################### FOOTER ######################-->
    <div class="card text-center bg-dark mt-5">
        <div class="card-body">
            <h5 class="card-title text-white">Copyrights</h5>
            <p class="card-text text-warning">@Donatify 2021</p>
        </div>
    </div>
	
</body>
</html>