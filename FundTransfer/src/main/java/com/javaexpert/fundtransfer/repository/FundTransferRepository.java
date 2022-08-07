package com.javaexpert.fundtransfer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaexpert.fundtransfer.model.FundTransfer;

@Repository
public interface FundTransferRepository extends JpaRepository<FundTransfer, String> {
	public List<FundTransfer> findByAccountFrom(String accountCode);
}
