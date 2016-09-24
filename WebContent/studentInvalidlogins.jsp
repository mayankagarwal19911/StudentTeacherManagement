<%
String result = request.getParameter("r");
if(result!=null){
	response.sendRedirect("seeker/login.jsp?r=f");
}
else{
	response.sendRedirect("seeker/login.jsp");
}
%>
