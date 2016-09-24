package com.sthirty.teacher.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sthirty.teacher.business.PublisherProfileUpdateBD;
import com.sthirty.teacher.dao.PublisherRegistrationClass;
/**
 * Servlet implementation class PublisherProfileUpdateController
 */
public class PublisherProfileUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/Html");
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		long contact = Long.parseLong(request.getParameter("contactnumber"));
		long publisherId = Long.parseLong(request.getParameter("publisherid"));
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
		registrationclass.setContactnumber(contact);
		registrationclass.setDob(dob);
		registrationclass.setQualification(qualification);
		registrationclass.setAddressline1(addressline1);
		registrationclass.setAddressline2(addressline2);
		registrationclass.setZip(zip);
		registrationclass.setCity(city);
		registrationclass.setState(state);
		registrationclass.setCountry(country);
		registrationclass.setPublisherId(publisherId);
		
		PublisherProfileUpdateBD profileupdatebd = new PublisherProfileUpdateBD();
		boolean status = profileupdatebd.profileUpdate(registrationclass);
		if(status){
			response.sendRedirect("publisherProfileRedirect.jsp");
		}
		else{
			response.sendRedirect("publisherProfileRedirect.jsp?r=f");
		}
	}
}
