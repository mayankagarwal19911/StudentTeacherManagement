<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://code.jquery.com/jquery-latest.min.js"
        type="text/javascript"></script>
<link href="../assets/css/style.css" rel='stylesheet' type='text/css' />
<%@ include file="../packagesImport/includeImports.jsp" %>
<%@include file="../../configuration/publisher/top-profile.jsp" %>
<title>Profile</title>
</head>
<style>
.col-xs-12 img{
	position:relative;
	width: 200px !important;
	height: 200px !important;
	z-index: 0;
}
input[type=submit]{
	 padding:10px;
	 float:left;
}

#popup{
	margin-top:-110px;
	display: none;
	background-color:#3C4C55; width: 100%;
}
</style>
<!-- ----------------------------------------------------

				Popup form to edit details

--------------------------------------------------------->
<div id="popup">
<div class="main" style="padding-top: 50px;">
		<A href="#0" id="esc">ESC</A>
		<form action="../PublisherProfileUpdateController" method="post">
		<input type="hidden" name="publisherid" value="<%=publisherId%>">
		   <div class="lable">
		        <div class="col_1_of_2 span_1_of_2"><input type="text" class="text" name="firstname" value="<%=firstname %>"></div><!--  id="active" -->
                <div class="col_1_of_2 span_1_of_2"><input type="text" class="text" name="lastname" value="<%=lastname %>"> </div>
                <div class="clear"></div>
		   </div>
		   <div class="lable"><!-- lable-2 -->
		        <div class="col_1_of_2 span_1_of_2"><input type="email" class="text" name="email" value="<%=email %>"></div>
		        <div class="col_1_of_2 span_1_of_2"><input type="text" name="contactnumber" class="text" value="<%=contactnumber %>"></div>
		   </div>
		    <div class="lable"><!-- lable-2 -->
		        <div class="col_1_of_2 span_1_of_2"><input type="date"  name="dob" class="text" value="<%=dob %>"></div>
		        <div class="col_1_of_2 span_1_of_2"><input type="text" name="qualification" class="text" value="<%=qualification %>"></div>
		   		<div class="clear"></div>
		   </div>
		    <div class="lable">
		        <div class="col_1_of_2 span_1_of_2"><input type="text" name="addressline1" class="text" value="<%=addressline1 %>"></div><!--  id="active" -->
                <div class="col_1_of_2 span_1_of_2"><input type="text" name="addressline2" class="text" value="<%=addressline2 %>"></div>
                <div class="clear"></div>
		   </div>
		   <div class="lable">
                <div class="col_1_of_2 span_1_of_2"><input type="text" name="zip" class="text" value="<%=zip %>" ></div>
		        <div class="col_1_of_2 span_1_of_2"><input type="text" name="city" class="text" value="<%=city %>"></div><!--  id="active" -->
                <div class="clear"></div>
		   </div>
		   <div class="lable">
		        <div class="col_1_of_2 span_1_of_2"><input type="text" name="state" class="text" value="<%=state %>"></div><!--  id="active" -->
                <div class="col_1_of_2 span_1_of_2"><input type="text" name="country" class="text" value="<%=country %>"></div>
                <div class="clear"></div>
		   </div>
		   <div class="submit">
			  <input type="submit" value="update" >
		   </div>
		   <br><br><br><br>
		   <div class="clear"></div>
		</form>
		<!-----//end-main---->
</div>
</div>
<body>
<main id="main">
	<div class="container">
		<div class="row topspace">
			<!-- Sidebar -->
			<aside class="col-md-3 sidebar sidebar-left">
<!-- 				<div class="row widget">
					<div class="col-xs-12">
						<h4>Lorem ipsum dolor sit</h4>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Facere, ratione delectus reiciendis nulla nisi pariatur molestias animi eos repellat? Vel.</p>
					</div>
				</div> -->
				<div class="row widget">
					<div class="col-xs-12 change">
						<form action="../PublisherImageController" method="post" enctype="multipart/form-data">
 							<input type="hidden"  value="<%=publisherId %>" name="publisherId">
 							<input type="file"  name="file" required="required">
 							<input type="submit" value="upload">
 						</form>
						<!-- image -->
						<img src="../publisher-images/<%=publisherId%>/<%=publisherId%>.jpg">
					</div>
				</div>
			</aside>			
			<!-- /Sidebar -->
			<article class="col-sm-2 maincontent">
				<p style="color:red; text-align: center;">
					<%
							String alreadyRegisteredMessage = (String)request.getParameter("r");
							if(alreadyRegisteredMessage!=null){
								out.print("Sorry, can not update your profile. Please try again !");%> 
							<%}
							else{
								out.print("");
							}
						%>
					</p>
			</article>
			<!-- Article main content -->
			<article class="col-sm-7 maincontent">
				<header class="page-header">
					<h3 class="page-title">Personal Information<span style="float: right; font-size: 17px;" id="edit"><a href="#0">Edit</a></span></h3>
				</header>
				<ul>
					<li><strong>Name: </strong><%=firstname %>&nbsp;<%=lastname %></li>
					<li><strong>Email : </strong><%=email %></li>
					<li><strong>Date of Birth : </strong><%=dob %></li>
					<li><strong>Contact number : </strong><%=contactnumber %></li>
					<li><strong>Highest Qualification : </strong><%=qualification %></li>
					<li><strong>Address : </strong><%=addressline1 %>, <%=addressline2 %>, <%=zip %>, <%=city %>, <%=state %>, <%=country %>
					</li>
				</ul>
			</article>
			<!-- /Article -->
		</div>
	</div>	<!-- /container -->
</main>
<!-- -------------------------------------

J-query for popup form

 -------------------------------------- -->
<script type="text/javascript">
	$(document).keyup(function(e) {
	    if (e.which == 27) {
	    	$('#popup').hide();
			$('#main').show();
			$('#header').show();
			$('#footer').show();
			$('#underfooter').show(); 
	    }
	});

	$('#edit').click(function(){
		$('#popup').fadeIn(1000);
		$('#main').hide();
		$('#header').hide();
		$('#footer').hide();
		$('#underfooter').hide();
	})
	
	$('#esc').click(function(){
		$('#popup').hide();
		$('#main').show();
		$('#header').show();
		$('#footer').show();
		$('#underfooter').show();
	})
</script>