package com.sthirty.teacher.business;
import com.sthirty.teacher.dao.PublisherLoginDAO;
import com.sthirty.teacher.dao.PublisherRegistrationClass;
/**
 * 
 * @author Mayank
 * This business class will call the DAO class method 
 * to pass LoginDAO class object that will be used
 * to login after authenticating  user details entered by user.
 */
public class PublisherLoginBD {
	
	/**
	 * 
	 * @param registrationclass (parameter of type RegistrationClass)
	 * @return true or false depends upon the result
	 * 
	 */
	public boolean publisherLogin(PublisherRegistrationClass registrationclass){
		PublisherLoginDAO logindao = new PublisherLoginDAO();
		return logindao.loginDAO(registrationclass);		
	}
}
