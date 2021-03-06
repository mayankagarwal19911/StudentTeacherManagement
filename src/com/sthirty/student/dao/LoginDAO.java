package com.sthirty.student.dao;
import java.util.Iterator;
import org.hibernate.Query;
import org.hibernate.Session;
import com.sthirty.dao.HibernateUtilityManager;
/**
 * 
 * @author Mayank
 * This DAO class will perform the registration process with
 * database by storing all the user entered values to database
 */
public class LoginDAO {
	/**
	 * 
	 * @param registrationclass (parameter of type RegistrationClass)
	 * @return true/false based on values inserted to database
	 */
	public boolean loginDAO(RegistrationClass registrationclass){
		boolean status = false;
		int count = 0;
		try{
			Session hibernatesession = HibernateUtilityManager.getSession();
			String hql = "select  email, dob, password from RegistrationClass where email = '"+registrationclass.getEmail()+"'and dob = '"+registrationclass.getDob()+"' and password = '"+registrationclass.getPassword()+"'";
			Query querytochecklogins = hibernatesession.createQuery(hql);
			for(@SuppressWarnings("unchecked")
			Iterator<RegistrationClass> iterator = querytochecklogins.iterate(); iterator.hasNext();)
			{   iterator.next();
				count++;
			}// for ends
			if(count==1){
				status =  true;
			}
			else{
				status =  false;
			}
		}
		catch(Exception e){e.printStackTrace();}
		finally{
			HibernateUtilityManager.closeSession();
		}
		return status;
	}
}
