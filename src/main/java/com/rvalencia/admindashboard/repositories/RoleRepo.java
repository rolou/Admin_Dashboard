package com.rvalencia.admindashboard.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rvalencia.admindashboard.models.Role;

public interface RoleRepo extends CrudRepository<Role, Long>{
	
	List<Role> findAll();

	List<Role> findByName(String name);
}
