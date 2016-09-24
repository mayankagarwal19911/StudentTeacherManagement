package com.sthirty.teacher.dao;
import java.util.Iterator;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sthirty.dao.HibernateUtilityManager;
/**
 * 
 * @author Mayank
 * This DAO class will perform the registration process with
 * database by storing all the user entered values to database
 */
public class PublisherRegistrationDAO {
	/**
	 * 
	 * @param registrationclass (parameter of type RegistrationClass)
	 * @return true/false based on values inserted to database
	 */
	public boolean registrationDAO(PublisherRegistrationClass registrationclass){
		boolean status = false;
		int count = 0;
		try{
			Session hibernatesession = HibernateUtilityManager.getSession();
			/**
			 * below code will check if email is already registered
			 */
			String hql = "select email from PublisherRegistrationClass where email = '"+registrationclass.getEmail()+"' ";
			Query querytocheck = hibernatesession.createQuery(hql);
			for (@SuppressWarnings("rawtypes")
			Iterator iterator = querytocheck.iterate(); iterator.hasNext();)
	        {            iterator.next();
	           count++;
	        }
			if(count==1){
				status = false;}
			else{			
			Transaction transaction = hibernatesession.beginTransaction();
			registrationclass.setFirstname(registrationclass.getFirstname());
			registrationclass.setLastname(registrationclass.getLastname());
			registrationclass.setEmail(registrationclass.getEmail());
			registrationclass.setPassword(registrationclass.getPassword());
			registrationclass.setContactnumber(registrationclass.getContactnumber());
			registrationclass.setDob(registrationclass.getDob());
			registrationclass.setQualification(registrationclass.getQualification());
			registrationclass.setQualification(registrationclass.getQualification());
			registrationclass.setAddressline1(registrationclass.getAddressline1());
			registrationclass.setAddressline2(registrationclass.getAddressline2());
			registrationclass.setZip(registrationclass.getZip());
			registrationclass.setState(registrationclass.getState());
			registrationclass.setCity(registrationclass.getCity());
			registrationclass.setCountry(registrationclass.getCountry());
			hibernatesession.save(registrationclass);
			transaction.commit();
			status = true;	
			}
		}
		catch(Exception e){e.printStackTrace();}
		finally{
			HibernateUtilityManager.closeSession();
		}
		return status;
	}
}
