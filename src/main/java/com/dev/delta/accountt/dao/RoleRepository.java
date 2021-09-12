package com.dev.delta.accountt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.delta.accountt.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
