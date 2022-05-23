package com.kcsitglobal.purchase.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kcsitglobal.purchase.model.Purchase;
import com.kcsitglobal.purchase.service.PurchaseService;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

	@Autowired
	PurchaseService purchaseService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/get-PurchaseRecord")
	public Object getPurchaseRecords() {
		@SuppressWarnings("unchecked")
		List<Purchase> purchase = (List<Purchase>) purchaseService.getPurchaseRecords();
		logger.info(purchase.toString());
		return purchase;
	}

	@GetMapping("/get-PurchaseId")
	public Object getPurchaseId(@RequestParam Long id) {
		Object purchase = purchaseService.getPurchaseId(id);
		logger.info(purchase.toString());
		return purchase;
	}

	@GetMapping("/get-Purchasequantity")
	public Object getPurchaseQuantity(@RequestParam double quantity) {
		@SuppressWarnings("unchecked")
		List<Purchase> purchase = purchaseService.getPurchaseQuantity(quantity);
		logger.info(purchase.toString());
		return purchase;
	}

	@GetMapping("/get-PurchasebyPrice")
	public Object getPurchasebyPrice(@RequestParam double price) {
		@SuppressWarnings("/unchecked")
		List<Purchase>purchase=purchaseService.getPurchaseByPrice(price);
		logger.info(purchase.toString());
		return  purchase;
	}
	@PostMapping("/add-purchaseRecord")
     public Object addrecord(@RequestBody Purchase purchase) {
    	 logger.info(purchase.toString());
    	 return purchaseService.addrecord(purchase);
     }
	
	@PutMapping("/update-PurchaseRecord")
	public Object updateRecord(@RequestBody Purchase purchase) {
		logger.info(purchase.toString());
		return purchaseService.updateRecord(purchase);
		
	}
	
	@DeleteMapping("/delete-PurchaseRecord")
	public Object deletePurchaseRecord(@RequestParam Long id) {
		logger.info("Purchase id"+id);
		return purchaseService.deletePurchaseRecord(id);
	}
	
	
	
}
