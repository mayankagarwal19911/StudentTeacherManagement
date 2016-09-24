package com.sthirty.student.business;
import com.sthirty.student.dao.LoginDAO;
import com.sthirty.student.dao.RegistrationClass;
/**
 * 
 * @author Mayank
 * This business class will call the DAO class method 
 * to pass LoginDAO class object that will be used
 * to login after authenticating  user details entered by user.
 */
public class StudentLogin {
	
	/**
	 * 
	 * @param registrationclass (parameter of type RegistrationClass)
	 * @return true or false depends upon the result
	 * 
	 */
	public boolean loginStudent(RegistrationClass registrationclass){
		LoginDAO logindao = new LoginDAO();
		return logindao.loginDAO(registrationclass);		
	}
}
