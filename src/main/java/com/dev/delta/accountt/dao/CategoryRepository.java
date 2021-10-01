package com.dev.delta.accountt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.delta.accountt.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
