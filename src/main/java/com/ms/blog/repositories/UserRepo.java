package com.ms.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ms.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{
 
}


