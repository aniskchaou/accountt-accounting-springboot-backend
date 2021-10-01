package com.dev.delta.accountt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.accountt.dao.OrderRepository;
import com.dev.delta.accountt.entities.Order;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	public Order saveOrUpdate(Order order) {

		return orderRepository.save(order);
	}

	public Iterable<Order> findAll() {
		return orderRepository.findAll();
	}

	public Order findById(Long id) {
		return orderRepository.getOne(id);
	}

	public void delete(Long id) {
		Order order = findById(id);
		orderRepository.delete(order);
	}
}
