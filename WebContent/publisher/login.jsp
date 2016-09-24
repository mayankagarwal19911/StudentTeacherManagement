<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="../assets/css/style.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--webfonts-->
<link href='http://fonts.googleapis.com/css?family=Oxygen:400,300,700' rel='stylesheet' type='text/css'>
<!--//webfonts-->
<title>Login</title>
</head>
<body style="background-color:#3C4C55;">
<%!String message; %>
<%
String invalidDetailsMessage = request.getParameter("r");
	if(invalidDetailsMessage!=null){
		message = "Invalid details !";
	}
	else{
		message="";
	}
%>
<span style="color:white; display: block;"><a href="../index.jsp">HOME</a></span>
<div class="main">
	<div class="social-icons">
		<div class="clear"></div>	
    </div>
		<form action="../PublisherLoginController" method="post">
		    <div class="lable"><!-- lable-2 -->
			     <div class="col_1_of_2 span_1_of_2">
			     <label>Email</label>
			     	<input type="email" name="email" class="text" placeholder="your@email.com">
			     </div>
		         <div class="col_1_of_2 span_1_of_2">		         
			     <label>Date of birth</label>
		         	<input type="date"  name="dob" class="text" placeholder="your date of birth">
		         </div>
		   		<div class="clear"></div>
		   		<div class="lable-2"><!-- lable-2 -->
		        <input type="password" name="password" class="text" placeholder="My password">
		   		<div class="clear"></div>
		   </div>
		   </div>
		   <center><p style="color: white;"><%=message %></p></center>
		   <!-- <h3>By creating an account, you agree to our <span class="term"><a href="#">Terms & Conditions</a></span></h3> -->
		   <div class="submit">
			  <input type="submit" onclick="myFunction()" value="Login" >
		   </div>
		   <div class="clear"> </div>
		</form>		
		<h3 style="text-align: center;"><span class="term">Don't have an account ?&nbsp;&nbsp;<a href="register.jsp">Register</a></span></h3>
		<!-----//end-main---->
		</div>
</body>
