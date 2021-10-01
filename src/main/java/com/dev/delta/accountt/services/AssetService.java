package com.dev.delta.accountt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.delta.accountt.dao.AssetRepository;
import com.dev.delta.accountt.entities.Asset;

@Service
public class AssetService {
	@Autowired
	AssetRepository assetRepository;

	public Asset saveOrUpdate(Asset asset) {

		return assetRepository.save(asset);
	}

	public Iterable<Asset> findAll() {
		return assetRepository.findAll();
	}

	public Asset findById(Long id) {
		return assetRepository.getOne(id);
	}

	public void delete(Long id) {
		Asset asset = findById(id);
		assetRepository.delete(asset);
	}
}
