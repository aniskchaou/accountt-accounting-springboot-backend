package com.dev.delta.accountt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.delta.accountt.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
