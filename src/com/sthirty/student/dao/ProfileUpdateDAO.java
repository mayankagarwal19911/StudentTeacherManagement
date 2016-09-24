package com.sthirty.student.dao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sthirty.dao.*;
/**
 * 
 * @author Mayank Agarwal
 * Date : 17th August 2016
 * 
 * This DAO class will update Student profile 
 * information in database.
 */
public class ProfileUpdateDAO {
	boolean status = false;
	/**
	 * This function will update Student profile information to database.
	 * 
	 * @param registrationclass
	 * @return = return whether data has been successfully saved in database or not
	 */
	public boolean studentProfileUpdateDAO(RegistrationClass registrationclass){
		try{
			/**
			 * getting openSession function
			 */
			Session hibernatesession = HibernateUtilityManager.getSession();
			Transaction transaction = hibernatesession.beginTransaction();
			/**
			 * Update Query to update the fields in database 
			 */
			Query queryforprofileupdate = hibernatesession.createQuery("update RegistrationClass set firstname=:fname, lastname=:lname, email=:studentemail, contactnumber=:contact, dob=:studentdob, qualification=:highestqualification, addressline1=:address1, addressline2=:address2, zip=:zipcode, city=:residentcity, state=:residentstate, country=:residentcountry where studentId=:studentid");
			queryforprofileupdate.setParameter("fname", registrationclass.getFirstname());
			queryforprofileupdate.setParameter("lname", registrationclass.getLastname());
			queryforprofileupdate.setParameter("studentemail", registrationclass.getEmail());
			queryforprofileupdate.setParameter("contact", registrationclass.getContactnumber());
			queryforprofileupdate.setParameter("studentdob", registrationclass.getDob());
			queryforprofileupdate.setParameter("highestqualification", registrationclass.getQualification());
			queryforprofileupdate.setParameter("address1", registrationclass.getAddressline1());
			queryforprofileupdate.setParameter("address2", registrationclass.getAddressline2());
			queryforprofileupdate.setParameter("zipcode", registrationclass.getZip());
			queryforprofileupdate.setParameter("residentcity", registrationclass.getCity());
			queryforprofileupdate.setParameter("residentstate", registrationclass.getState());
			queryforprofileupdate.setParameter("residentcountry", registrationclass.getCountry());
			queryforprofileupdate.setParameter("studentid", registrationclass.getStudentId());
			/**
			 * Execute Update 
			 */
			queryforprofileupdate.executeUpdate();
			/**
			 * committing
			 */
			transaction.commit();
			System.out.println(registrationclass.getStudentId());
			status = true;
		}
		catch(Exception e){e.printStackTrace();}
		finally{HibernateUtilityManager.closeSession();}
		return status;
	}
}
