package com.StudManageSys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StudManageSys.entity.Student;


public interface StudentRepository extends JpaRepository<Student, String>{
    boolean existsById(String KodID);
	Student getById(String kodID);
    boolean existsByEmail(String email);
	Student getByEmail(String email);

}


