package com.ms.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
