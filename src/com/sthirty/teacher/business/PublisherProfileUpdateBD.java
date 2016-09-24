package com.sthirty.teacher.business;
import com.sthirty.teacher.dao.PublisherProfileUpdateDAO;
import com.sthirty.teacher.dao.PublisherRegistrationClass;

public class PublisherProfileUpdateBD {
	/**
	 * 
	 * @param registrationclass
	 * @return
	 */
	public boolean profileUpdate(PublisherRegistrationClass registrationclass){
		PublisherProfileUpdateDAO profileupdatedao = new PublisherProfileUpdateDAO();
		return profileupdatedao.publisherProfileUpdate(registrationclass);
	}
}
