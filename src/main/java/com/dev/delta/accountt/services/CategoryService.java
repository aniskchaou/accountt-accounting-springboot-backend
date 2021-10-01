package com.dev.delta.accountt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.accountt.dao.CategoryRepository;
import com.dev.delta.accountt.entities.Category;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;

	public Category saveOrUpdate(Category category) {

		return categoryRepository.save(category);
	}

	public Iterable<Category> findAll() {
		return categoryRepository.findAll();
	}

	public Category findById(Long id) {
		return categoryRepository.getOne(id);
	}

	public void delete(Long id) {
		Category category = findById(id);
		categoryRepository.delete(category);
	}
}
