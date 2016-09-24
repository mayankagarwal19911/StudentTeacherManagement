package com.sthirty.teacher.business;
import com.sthirty.teacher.dao.PublisherRegistrationClass;
import com.sthirty.teacher.dao.PublisherRegistrationDAO;

/**
 * 
 * @author Mayank
 * This business class will call the DAO class method 
 * to pass Registration class object that will be used
 * to register user enter details into database.
 */
public class PublisherRegistrationBD {
	/**
	 * 
	 * @param registrationclass (parameter of type RegistrationClass)
	 * @return true or false depends upon the result
	 */
	public boolean registerPublisher(PublisherRegistrationClass registrationclass){
		PublisherRegistrationDAO registrationdao = new PublisherRegistrationDAO();
		return registrationdao.registrationDAO(registrationclass);		
	}
}
