package com.dev.delta.accountt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.accountt.dao.TransferRepository;
import com.dev.delta.accountt.entities.Transfer;

@Service
public class TransferService {
	@Autowired
	TransferRepository transferRepository;

	public Transfer saveOrUpdate(Transfer transfer) {

		return transferRepository.save(transfer);
	}

	public Iterable<Transfer> findAll() {
		return transferRepository.findAll();
	}

	public Transfer findById(Long id) {
		return transferRepository.getOne(id);
	}

	public void delete(Long id) {
		Transfer transfer = findById(id);
		transferRepository.delete(transfer);
	}
}
