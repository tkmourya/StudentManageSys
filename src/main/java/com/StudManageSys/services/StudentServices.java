package com.StudManageSys.services;

import java.util.List;

import org.springframework.stereotype.Service;


import com.StudManageSys.entity.Student;
import com.StudManageSys.repository.StudentRepository;

public interface StudentServices {
	String addStudent(Student s);
	Student getStudent(String kodID);
	List<Student> getAllStudents();
	String updateStudent(Student s);
	String deleteStudent(String kodID);
	

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
		return "Student added successfully";
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
		return "Student updated successfully";
	}

	@Override
	public String deleteStudent(String kodID) {
		srep.deleteById(kodID);
		return "Student deleted";
	}
}
	