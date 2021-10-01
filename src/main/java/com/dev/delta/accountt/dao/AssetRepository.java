package com.dev.delta.accountt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.delta.accountt.entities.Asset;

public interface AssetRepository extends JpaRepository<Asset, Long> {

}
