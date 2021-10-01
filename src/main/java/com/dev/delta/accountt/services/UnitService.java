package com.dev.delta.accountt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.accountt.dao.UnitRepository;
import com.dev.delta.accountt.entities.Unit;

@Service
public class UnitService {

	@Autowired
	UnitRepository unitRepository;

	public Unit saveOrUpdate(Unit unit) {

		return unitRepository.save(unit);
	}

	public Iterable<Unit> findAll() {
		return unitRepository.findAll();
	}

	public Unit findById(Long id) {
		return unitRepository.getOne(id);
	}

	public void delete(Long id) {
		Unit unit = findById(id);
		unitRepository.delete(unit);
	}
}
