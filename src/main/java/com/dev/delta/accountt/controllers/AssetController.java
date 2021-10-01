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

import com.dev.delta.accountt.entities.Asset;
import com.dev.delta.accountt.services.AssetService;
@RestController
@RequestMapping("/asset")
@CrossOrigin
public class AssetController {

	@Autowired
	AssetService assetService;

	@PostMapping("/create")
	public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Asset projectAsset, BindingResult result) {

		if (result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<String, String>();

			for (FieldError error : result.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		}

		Asset newPT = assetService.saveOrUpdate(projectAsset);

		return new ResponseEntity<Asset>(newPT, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public Iterable<Asset> getAllAssets() {
		return assetService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Asset> getAssetById(@PathVariable Long id) {
		Asset asset = assetService.findById(id);
		return new ResponseEntity<Asset>(asset, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAsset(@PathVariable Long id) {
		assetService.delete(id);
		return new ResponseEntity<String>("asset was deleted", HttpStatus.OK);
	}
}
