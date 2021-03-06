package com.sthirty.student.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.sthirty.student.business.StudentLogin;
import com.sthirty.student.dao.RegistrationClass;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public boolean status = false;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			String email = request.getParameter("email");
			String dob = request.getParameter("dob");
			String password = request.getParameter("password");
			
			RegistrationClass registrationclass = new RegistrationClass();
			registrationclass.setEmail(email);
			registrationclass.setDob(dob);
			registrationclass.setPassword(password);
			
			status = new StudentLogin().loginStudent(registrationclass);
				if(status){
					HttpSession session = request.getSession();
					session.setAttribute("registrationclassObject", registrationclass);
					try{
					request.getRequestDispatcher("studentProfileRedirect.jsp").forward(request, response);
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				else{
					response.sendRedirect("studentInvalidlogins.jsp?r=f");
				}
	}
}
