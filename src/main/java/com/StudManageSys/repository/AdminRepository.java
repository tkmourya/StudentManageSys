package com.StudManageSys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StudManageSys.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {
	boolean existsByEmail(String email);
	Admin getByEmail(String email);

}
