package com.sthirty.student.business;
import com.sthirty.student.dao.ProfileUpdateDAO;
import com.sthirty.student.dao.RegistrationClass;

public class ProfileUpdateBD {
	public boolean profileUpdate(RegistrationClass registrationclass){
		ProfileUpdateDAO profileupdatedao = new ProfileUpdateDAO();
		return profileupdatedao.studentProfileUpdateDAO(registrationclass);
	}
}
