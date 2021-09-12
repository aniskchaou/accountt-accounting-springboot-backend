package com.dev.delta.accountt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.accountt.dao.UserAccounttRepository;
import com.dev.delta.accountt.entities.UserAccountt;

@Service
public class UserAccounttService {
	@Autowired
	UserAccounttRepository userRepository;

	public UserAccountt saveOrUpdate(UserAccountt user) {

		return userRepository.save(user);
	}

	public Iterable<UserAccountt> findAll() {
		return userRepository.findAll();
	}

	public UserAccountt findById(Long id) {
		return userRepository.getOne(id);
	}

	public void delete(Long id) {
		UserAccountt user = findById(id);
		userRepository.delete(user);
	}

}
