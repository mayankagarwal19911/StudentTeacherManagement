<%
String result = request.getParameter("r");
if(result!=null){
	response.sendRedirect("seeker/profile.jsp?r=f");
}
else{
	response.sendRedirect("seeker/profile.jsp");
}
%>
