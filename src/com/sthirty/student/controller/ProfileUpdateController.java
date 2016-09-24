package com.sthirty.student.controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sthirty.student.business.ProfileUpdateBD;
import com.sthirty.student.dao.RegistrationClass;

/**
 * Servlet implementation class ProfileUpdateController
 */
public class ProfileUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/Html");
		PrintWriter out = response.getWriter();
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		long contact = Long.parseLong(request.getParameter("contactnumber"));
		long studentId = Long.parseLong(request.getParameter("studentid"));
		String dob = request.getParameter("dob");
		String qualification = request.getParameter("qualification");
		String addressline1 = request.getParameter("addressline1");
		String addressline2 = request.getParameter("addressline2");
		int zip = Integer.parseInt(request.getParameter("zip"));
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		
		RegistrationClass registrationclass = new RegistrationClass();
		registrationclass.setFirstname(firstname);
		registrationclass.setLastname(lastname);
		registrationclass.setEmail(email);
		registrationclass.setContactnumber(contact);
		registrationclass.setDob(dob);
		registrationclass.setQualification(qualification);
		registrationclass.setAddressline1(addressline1);
		registrationclass.setAddressline2(addressline2);
		registrationclass.setZip(zip);
		registrationclass.setCity(city);
		registrationclass.setState(state);
		registrationclass.setCountry(country);
		registrationclass.setStudentId(studentId);
		
		ProfileUpdateBD profileupdatebd = new ProfileUpdateBD();
		boolean status = profileupdatebd.profileUpdate(registrationclass);
		if(status){
			response.sendRedirect("studentProfileRedirect.jsp");
		}
		else{
			response.sendRedirect("studentProfileRedirect.jsp?r=f");
		}
	}
}
