<%
String result = request.getParameter("r");
if(result!=null){
	response.sendRedirect("publisher/profile.jsp?r=f");
}
else{
	response.sendRedirect("publisher/profile.jsp");
}
%>
