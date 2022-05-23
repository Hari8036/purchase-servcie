package com.kcsitglobal.purchase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kcsitglobal.purchase.model.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long>{
	List<Purchase>findByQuantity(double quantity);
	List<Purchase>findByPrice(double price);
}