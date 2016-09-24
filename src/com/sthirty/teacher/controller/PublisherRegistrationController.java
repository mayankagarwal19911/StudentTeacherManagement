package com.sthirty.teacher.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.sthirty.teacher.business.PublisherRegistrationBD;
import com.sthirty.teacher.dao.PublisherRegistrationClass;

/**
 * 
 * @author Mayank 
 * 
 * This controller will control the flow of registration
 * form fields and will call he business method to pass object
 *
 */
public class PublisherRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		long contact = Long.parseLong(request.getParameter("contactnumber"));
		String dob = request.getParameter("dob");
		String qualification = request.getParameter("qualification");
		String addressline1 = request.getParameter("addressline1");
		String addressline2 = request.getParameter("addressline2");
		int zip = Integer.parseInt(request.getParameter("zip"));
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		
		PublisherRegistrationClass registrationclass = new PublisherRegistrationClass();
		registrationclass.setFirstname(firstname);
		registrationclass.setLastname(lastname);
		registrationclass.setEmail(email);
		registrationclass.setPassword(password);
		registrationclass.setContactnumber(contact);
		registrationclass.setDob(dob);
		registrationclass.setQualification(qualification);
		registrationclass.setAddressline1(addressline1);
		registrationclass.setAddressline2(addressline2);
		registrationclass.setZip(zip);
		registrationclass.setCity(city);
		registrationclass.setState(state);
		registrationclass.setCountry(country);
		
		PublisherRegistrationBD publisherregistration = new PublisherRegistrationBD();
		boolean status = publisherregistration.registerPublisher(registrationclass);
		if(status){
			HttpSession session = request.getSession();
			session.setAttribute("registrationclassObject", registrationclass);
			request.getRequestDispatcher("seeker/profile.jsp").forward(request, response);
		}
		else{
			response.sendRedirect("publisherEmailAlreadyRegisteredRedirect.jsp");
		}
	}
}
