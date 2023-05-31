package com.StudManageSys.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Studenttt")
public class Student {
	@Id
	String kodID;
	String name;
	String branch;
	String email;
	String dob;
	String gender;
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
public Student(String kodID, String name, String branch, String email, String dob, String gender) {
	super();
	this.kodID = kodID;
	this.name = name;
	this.branch = branch;
	this.email = email;
	this.dob = dob;
	this.gender = gender;
}
public String getKodID() {
	return kodID;
}
public void setKodID(String kodID) {
	this.kodID = kodID;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getBranch() {
	return branch;
}
public void setBranch(String branch) {
	this.branch = branch;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}



}
