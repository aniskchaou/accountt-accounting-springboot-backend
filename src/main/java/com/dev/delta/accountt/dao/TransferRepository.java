package com.dev.delta.accountt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.delta.accountt.entities.Transfer;

public interface TransferRepository extends JpaRepository<Transfer, Long>{

}
