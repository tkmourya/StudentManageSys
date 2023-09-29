package com.StudManageSys.services;

import java.util.List;

import org.springframework.stereotype.Service;


import com.StudManageSys.entity.Student;
import com.StudManageSys.repository.StudentRepository;

public interface StudentServices {
	String addStudent(Student s);
	String addSuccessMassage();
	boolean checkId(String kodID);    //check id already exist in database or not
	boolean checkEmail(String email); //check email already exist in database or not
	String addExists();               // print exist or not on web page(Register)
	Student getStudent(String kodID);
	List<Student> getAllStudents();
	String updateStudent(Student s);
	String updateSuccessMassage();
	String updateExists();
	String deleteStudent(String kodID);
	String removeSuccessMassage();
	String removeExists();
	

}
@Service
class StudentServicesImplementation implements StudentServices{
	StudentRepository srep;
	
	StudentServicesImplementation(StudentRepository srep){
		this.srep=srep;
	}

	@Override
	public String addStudent(Student s) {
		srep.save(s);
		return "Student added successfully !";
	}

	@Override
	public String addSuccessMassage() {
		return "Successfully Added !";
	}
	
	@Override
	public boolean checkId(String kodID) {
		return srep.existsById(kodID);
	}

	@Override
	public boolean checkEmail(String email) {
		return srep.existsByEmail(email);
	}

	@Override
	public String addExists() {
		return "Already exists Please enter new data !";
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> slist=srep.findAll();
		return slist;
	}

	@Override
	public Student getStudent(String kodID) {
		Student st=srep.findById(kodID).get();
		return st;
	}

	@Override
	public String updateStudent(Student s) {
		srep.save(s);
		return "Student updated successfully !";
	}
	
	@Override
		public String updateSuccessMassage() {
		return "Successfully Updated !";
	}
	
	@Override
	public String updateExists() {
		return " ID does not exist, and you have not updated it !";
	}
	
	@Override
	public String deleteStudent(String kodID) {
		srep.deleteById(kodID);
		return "Student deleted !";
	}

	@Override
	public String removeSuccessMassage() {
		return "Removed Successfully !";
	}

	@Override
	public String removeExists() {
		return " ID does not exist, and you have not removed it !";
	}

	

	

	

	
}
	