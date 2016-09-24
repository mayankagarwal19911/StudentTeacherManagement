<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="../assets/css/style.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--webfonts-->
<link href='http://fonts.googleapis.com/css?family=Oxygen:400,300,700' rel='stylesheet' type='text/css'>
<!--//webfonts-->
<title>Register</title>
</head>
<body style="background-color:#3C4C55;">
<span style="color:white; display: block;"><a href="../index.jsp">HOME</a></span>
<div class="main">
	<div class="social-icons">
		 <div class="col_1_of_f span_1_of_f"><a href="#">
		    <ul class='facebook'>
		    	<i class="fb"> </i>
		    	<li>Connect with Facebook</li>
		    	<div class='clear'> </div>
		    </ul>
		    </a>
		 </div>	
		 <div class="col_1_of_f span_1_of_f"><a href="#">
		    <ul class='twitter'>
		      <i class="tw"> </i>
		      <li>Connect with Twitter</li>
		      <div class='clear'> </div>
		    </ul>
		    </a>
		</div>
		<div class="clear"> </div>	
      </div>
      <h2>Or Signup with</h2>
		<form action="../RegistrationController" method="post">
		   <div class="lable">
		        <div class="col_1_of_2 span_1_of_2"><input type="text" class="text" name="firstname" placeholder="First Name" onfocus="this.placeholder = '';" onblur="if (this.placeholder == '') {this.placeholder = 'First Name';}"></div><!--  id="active" -->
                <div class="col_1_of_2 span_1_of_2"><input type="text" class="text" name="lastname" placeholder="Last Name" onfocus="this.placeholder = '';" onblur="if (this.placeholder == '') {this.placeholder = 'Last Name';}"></div>
                <div class="clear"></div>
		   </div>
		   <div class="lable"><!-- lable-2 -->
		        <div class="col_1_of_2 span_1_of_2"><input type="email" class="text" name="email" placeholder="your@email.com " onfocus="this.placeholder = '';" onblur="if (this.placeholder == '') {this.placeholder = 'your@email.com ';}"></div>
		        <div class="col_1_of_2 span_1_of_2"><input type="text" name="contactnumber" class="text" placeholder="Contact number" onfocus="this.placeholder = '';" onblur="if (this.placeholder == '') {this.placeholder = 'Contact ';}"></div>
		  	    <div class="clear">
		  	    	<p style="color:red; text-align: center;">
						<%
							String alreadyRegisteredMessage = (String)request.getParameter("r");
							if(alreadyRegisteredMessage!=null){
								out.print("Email Already Registered");%> 
							<h3 style="text-align: center;"><span class="term">OOPS ! You already have an account !&nbsp;&nbsp;<a href="login.jsp">Login</a></span></h3>
							<%}
							else{
								out.print("");
							}
						%>
					</p>
		  	    </div>
		   </div>
		    <div class="lable-2"><!-- lable-2 -->
		        <input type="password" name="password" class="text" placeholder="My password">
		   		<div class="clear"></div>
		   </div>
		    <div class="lable"><!-- lable-2 -->
		        <div class="col_1_of_2 span_1_of_2"><input type="date"  name="dob" class="text" placeholder="your date of birth" ></div>
		        <div class="col_1_of_2 span_1_of_2"><input type="text" name="qualification" class="text" placeholder="Highest Qualification " ></div>
		   		<div class="clear"></div>
		   </div>
		    <div class="lable">
		        <div class="col_1_of_2 span_1_of_2"><input type="text" name="addressline1" class="text" placeholder="Address line 1" ></div><!--  id="active" -->
                <div class="col_1_of_2 span_1_of_2"><input type="text" name="addressline2" class="text" placeholder="Address line 2" ></div>
                <div class="clear"></div>
		   </div>
		   <div class="lable">
                <div class="col_1_of_2 span_1_of_2"><input type="text" name="zip" class="text" placeholder="Zip" ></div>
		        <div class="col_1_of_2 span_1_of_2"><input type="text" name="city" class="text" placeholder="City" ></div><!--  id="active" -->
                <div class="clear"></div>
		   </div>
		   <div class="lable">
		        <div class="col_1_of_2 span_1_of_2"><input type="text" name="state" class="text" placeholder="State" ></div><!--  id="active" -->
                <div class="col_1_of_2 span_1_of_2"><input type="text" name="country" class="text" placeholder="Country" ></div>
                <div class="clear"></div>
		   </div>
		   <!-- <h3>By creating an account, you agree to our <span class="term"><a href="#">Terms & Conditions</a></span></h3> -->
		   <div class="submit">
			  <input type="submit" value="Register" >
		   </div>
		   <div class="clear"></div>
		</form>
		<h3 style="text-align: center;"><span class="term">Already have an account ?&nbsp;&nbsp;<a href="login.jsp">Login</a></span></h3>
		<!-----//end-main---->
		</div>
</body>
