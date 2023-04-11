package com.vishal.User.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vishal.User.Entity.User;

public interface UserRepo extends JpaRepository<User,Integer>{
    
}
