<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Examify - Login</title>

<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/custom_css/login.css">
</head>
<body>
	<%@include file="navbar.html"%>
	
	<div class="container id="container-body">
	<div class="row">
			<div class="col-lg-8">
				<div class="card" id="card">
					<div class="card-body cb-color">
						<h2 class="card-title" id="titlefont" align="center">Examify Login</h2>
							<form action="login" method="post">
								<div class="form-group inner-addon left-addon">
									<input type="text" class="form-control" name="username" placeholder="Username" required>
									<span class="glyphicon glyphicon-user"></span>
									
								</div>
								<div class="form-group inner-addon left-addon">
									<input type="password" class="form-control" name="password" placeholder="Password" required>
									<span class="glyphicon glyphicon-lock "></span>
								</div>
								<div class="form-group">
									<div class="radio" type id="radio">
										<label class="radio-inline"><input class="radio" type="radio" name="role" value="student" required>Student</label>
										<label class="radio-inline"><input class="radio" type="radio" name="role" value="teacher" required>Teacher</label>
										<label class="radio-inline"><input class="radio" type="radio" name="role" value="admin" required>Admin</label>
									</div>
								</div>
								<div class="form-group">
									<input type="submit" class="btn btn-success btn-block" value="Login">
								</div>
							</form>
						</div>
					<div class="card-footer text-muted text-center">
						<span id="footertxt">Not Registered Yet?</span>
						<br>
						<a href="register.jsp"><span id="footertxt1">Register</span></a>
					</div>
					<br>
					<p align="center">
						<%!
							String msg = null;
							String errormsg = null;
						%>
						<%
							msg = (String)request.getAttribute("msg");
							if(msg != null && msg.equals("Role Error")){
								out.println("<b> Role Error. Please login with Correct Role Type. </b>");
								//if(msg.equals("NT"))
									//out.println("<b>You are not a teacher. Please login correctly </b>");
								//else if(msg.equals("NS"))
									//out.println(" <b>You are not a student. Please login correctly </b>");
								/* else if(msg.equals("INVALID")){
									out.println("<b>Invalid Username/Password </b>");
								} */
							}else if(msg != null && msg.equals("INVALID")){
								out.println("<b>Invalid Credentials.</b>");
							}
						
						
						%>
					
					</p>
					
				</div>
			
			</div>
		</div>
	
	</div>

</body>
</html>