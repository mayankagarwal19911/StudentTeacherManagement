package com.sthirty.student.business;
import com.sthirty.student.dao.RegistrationClass;
import com.sthirty.student.dao.RegistrationDAO;

/**
 * 
 * @author Mayank
 * This business class will call the DAO class method 
 * to pass Registration class object that will be used
 * to register user enter details into database.
 */
public class StudentRegistration {
	/**
	 * 
	 * @param registrationclass (parameter of type RegistrationClass)
	 * @return true or false depends upon the result
	 */
	public boolean registerStudent(RegistrationClass registrationclass){
		RegistrationDAO registrationdao = new RegistrationDAO();
		return registrationdao.registrationDAO(registrationclass);		
	}
}
