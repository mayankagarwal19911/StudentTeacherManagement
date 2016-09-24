<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Profile</title>
	<%@ include file="../../packagesImport/includeImports.jsp" %>
	<link rel="shortcut icon" href="assets/images/gt_favicon.png">
	<!-- Bootstrap -->
	<link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.no-icons.min.css" rel="stylesheet">
	<!-- Icons -->
	<link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
	<!-- Fonts -->
	<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Alice|Open+Sans:400,300,700">
	<!-- Custom styles -->
	<!--[if lt IE 9]> <script src="assets/js/html5shiv.js"></script> <![endif]-->
</head>
    <%
	PublisherRegistrationClass registrationclassObject = (PublisherRegistrationClass)session.getAttribute("registrationclassObject");
	%>
	<!-- 
	Fetching session objects when 
	publisher successfully logins so that session
	could be manage using this information.
	-->
	<%
	long publisherId = registrationclassObject.getPublisherId();
	String email = registrationclassObject.getEmail();
	String dob = registrationclassObject.getDob();
	%>
	<!-- global variables to store user data to send on each page 
	-->
	<%!
	String firstname;
	String lastname;
	Long contactnumber;
	String qualification;
	String addressline1, addressline2, city, state, country;
	int zip;
	%>
	<!-- 
	Query to fetch fetch username, email and feelancerId based on session values
	that we set as username and password 
	 -->
	<%
	try{
		Session hibernatesession = HibernateUtilityManager.getSession();
		String hqlforpublisherdetails = "from PublisherRegistrationClass  where email = '"+email+"' and dob = '"+dob+"'";		
		Query queryforpublisherdetails = hibernatesession.createQuery(hqlforpublisherdetails);
			@SuppressWarnings("unchecked")
			List<PublisherRegistrationClass> listForpublisherdetails = queryforpublisherdetails.list();
			for(PublisherRegistrationClass publisherComponents : listForpublisherdetails){
				//getting Student details based on email and dob
				// that we set as session Attribute after login
				firstname = publisherComponents.getFirstname();
				lastname = publisherComponents.getLastname();
				contactnumber = publisherComponents.getContactnumber();
				qualification = publisherComponents.getQualification();
				addressline1 = publisherComponents.getAddressline1();
				addressline2 = publisherComponents.getAddressline2();
				city = publisherComponents.getCity();
				state = publisherComponents.getState();
				country = publisherComponents.getCountry();
				zip = publisherComponents.getZip();
				publisherId = publisherComponents.getPublisherId();
			}
	}
	catch(Exception e){e.printStackTrace();}
	finally{HibernateUtilityManager.closeSession();}
	%>
<body class="home" style="position: relative;">
<header id="header">
	<div id="head" class="parallax" parallax-speed="1">
		<h1 id="logo" class="text-center">
			<span class="title"><%=firstname %>&nbsp;<%=lastname %></span><br>
			<span class="tagline"><%=qualification %><br>
				<a href=""><%=email %></a></span>
		</h1>
	</div>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="index.html">Home</a></li>
					<li class="active"><a href="about.html">About</a></li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">More Pages <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="sidebar-left.html">Left Sidebar</a></li>
							<li><a href="sidebar-right.html">Right Sidebar</a></li>
							<li><a href="single.html">Blog Post</a></li>
						</ul>
					</li>
					<li><a href="login.jsp">Login</a></li>
				</ul>
			</div><!-- /.nav-collapse -->			
		</div>	
	</nav>
</header>