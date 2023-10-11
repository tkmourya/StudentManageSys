package com.StudManageSys.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudManageSys.entity.Admin;
import com.StudManageSys.repository.AdminRepository;

public interface AdminServices {
	String addUsers(Admin admin);// add user in database
	String addSuccess();
	boolean checkEmail(String email); //check email already exist in database or not
	String addExists(); // print exist or not on web page(Register)
	String loginExists();//print exist or not on web page(Login)
	boolean validate(String email, String password); // validation (login)
	boolean adminValidate(String email, String password);
	String getAdminEmail(String email);
	
	

}

@Service
class AdminServicesImplementation implements AdminServices{
	
	@Autowired
	AdminRepository adminRepository;

	@Override
	public String addUsers(Admin admin) {
		try {
            adminRepository.save(admin);
            return "Added successfully";
        } catch (Exception e) {
            return "Error occurred while Registration";
        }
	}
	
	@Override
	public String addSuccess() {
		return " Application Success !";
	}

	@Override
	public boolean checkEmail(String email) {
		return adminRepository.existsByEmail(email);
	}

	@Override
	public String addExists() {
		return "Already Exists !";
	}

	@Override
	public String loginExists() {
		return "Incorrect credentials, try again !";
	}

	@Override
	public boolean validate(String email, String password) {
		if(adminRepository.existsByEmail(email)) {
			Admin a=adminRepository.getByEmail(email);
			String dbpassword=a.getPassword();
			if(password.equals(dbpassword)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

	@Override
	public boolean adminValidate(String email, String password) {
		if(adminRepository.existsByEmail(email)) {
			Admin a=adminRepository.getByEmail(email);
			String dbpassword=a.getPassword();
			if(password.equals(dbpassword)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

	@Override
	public String getAdminEmail(String email) {
		Admin a=adminRepository.getByEmail(email);
		return a.getEmail();
	}

	
	
}