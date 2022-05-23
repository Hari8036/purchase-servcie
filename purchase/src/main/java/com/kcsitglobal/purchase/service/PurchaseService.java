package com.kcsitglobal.purchase.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.kcsitglobal.purchase.model.Purchase;
import com.kcsitglobal.purchase.repository.PurchaseRepository;

@Service
public class PurchaseService {
	
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PurchaseRepository purchaseRepository;

	public List<Purchase> getPurchaseRecords() {
		return purchaseRepository.findAll();
	}

	public Object getPurchaseId(Long id) {
		return purchaseRepository.findById(id);
	}

	public  List<Purchase> getPurchaseQuantity(double quantity) {
		return purchaseRepository.findByQuantity(quantity);
	}

	public List<Purchase> getPurchaseByPrice(double price) {
		
		return purchaseRepository.findByPrice(price);
	}

	public Object addrecord(Purchase purchase) {
		logger.info(purchase.toString());
		purchaseRepository.save(purchase);
		logger.info("Purchase record Addded Sucessfully");
		return new ResponseEntity<>("Purchase Record Added Sucessfully",HttpStatus.CREATED);
	}

	public Object updateRecord(Purchase purchase) {
		JsonObject response=new JsonObject();	
		System.out.println("Request Purchase:"+purchase);
		Long id=purchase.getId();
		try {
			Purchase pur=purchaseRepository.getOne(id);
			System.out.println("Request Purchase:"+pur);
			System.out.println("Old Purchase:"+pur);
			pur.setPrice(purchase.getPrice());
			System.out.println("New Purchase:"+pur);
			purchaseRepository.save(pur);
		}catch(Exception e)
		{
			logger.info(e.getMessage());
			response.addProperty("statusCode", 404);
			response.addProperty("statusCode", e.getMessage());
			return new ResponseEntity<>(response.toString(), HttpStatus.NOT_FOUND);
		}
		logger.info("Purchase Record Updated Sucessfully");
		return new ResponseEntity<>("PucrhaseRecord Updated Sucessfully", HttpStatus.OK);
		}

	public Object deletePurchaseRecord(Long id) {
		try {
		purchaseRepository.deleteById(id);
	} catch (Exception e) {
		logger.error(e.getMessage());
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	logger.info("Purchase Record Deleted Sucesfully");
	return new ResponseEntity<>("Purchase Record Deleted sucessfully", HttpStatus.OK);

	}
}

