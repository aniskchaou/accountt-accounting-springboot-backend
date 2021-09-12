package com.dev.delta.accountt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.delta.accountt.dao.ClientRepository;
import com.dev.delta.accountt.dao.SupplierAccounttRepository;
import com.dev.delta.accountt.entities.Client;
import com.dev.delta.accountt.services.ClientService;

@RestController
@RequestMapping("/accountt/dashboard")
@CrossOrigin
public class AccounttDashBoardController {

	@Autowired
	ClientRepository clientService;

	@Autowired
	SupplierAccounttRepository supplierService;

	@GetMapping("/clients")
	public long getClients() {
		return clientService.count();
	}

	@GetMapping("/suppliers")
	public long getSuppliers() {
		return supplierService.count();
	}

}
