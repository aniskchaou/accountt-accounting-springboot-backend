package com.dev.delta.accountt.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.delta.accountt.entities.Unit;
import com.dev.delta.accountt.services.UnitService;

@RestController
@RequestMapping("/unit")
@CrossOrigin
public class UnitController {

	@Autowired
	UnitService unitService;

	@PostMapping("/create")
	public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Unit projectUnit, BindingResult result) {

		if (result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<String, String>();

			for (FieldError error : result.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		}

		Unit newPT = unitService.saveOrUpdate(projectUnit);

		return new ResponseEntity<Unit>(newPT, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public Iterable<Unit> getAllUnits() {
		return unitService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Unit> getUnitById(@PathVariable Long id) {
		Unit unit = unitService.findById(id);
		return new ResponseEntity<Unit>(unit, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUnit(@PathVariable Long id) {
		unitService.delete(id);
		return new ResponseEntity<String>("unit was deleted", HttpStatus.OK);
	}
}
