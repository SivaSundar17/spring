package com.springboot.demo.repo;

import com.springboot.demo.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{
    
    public User findByEmail(String email);

}
