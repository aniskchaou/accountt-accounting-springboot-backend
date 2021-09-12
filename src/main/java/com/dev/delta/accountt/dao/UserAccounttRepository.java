package com.dev.delta.accountt.dao;

import com.dev.delta.accountt.entities.UserAccountt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccounttRepository extends JpaRepository<UserAccountt, Long> {
	UserAccountt findByUsername(String username);
}
