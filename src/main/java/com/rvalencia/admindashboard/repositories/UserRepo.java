package com.rvalencia.admindashboard.repositories;


import org.springframework.data.repository.CrudRepository;

import com.rvalencia.admindashboard.models.User;

public interface UserRepo extends CrudRepository<User, Long>{
	User findByUsername(String username);
}
