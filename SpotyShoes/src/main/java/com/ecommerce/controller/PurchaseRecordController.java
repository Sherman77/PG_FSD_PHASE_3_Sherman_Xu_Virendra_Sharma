package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.PurchaseRecord;
import com.ecommerce.model.PurchaseRecordSearchBody;
import com.ecommerce.repository.PurchaseRecordRepository;
import com.ecommerce.specification.PurchaseRecordSpecification;

@RestController
@RequestMapping("purchases")
public class PurchaseRecordController {

	@Autowired
	PurchaseRecordRepository pruchaseRecordRepository;
	
	//Get all purchase records
	@GetMapping("all")
	public List<PurchaseRecord> getAllPurchaseRecord() {
		List<PurchaseRecord> purchases = (List<PurchaseRecord>) pruchaseRecordRepository.findAll();
		return purchases;
	}
	
	//Add a purchase record
	@PostMapping("add")
	public PurchaseRecord addPurchaseRecord(@RequestBody PurchaseRecord purchase) {
		return pruchaseRecordRepository.save(purchase);
	}
	
	//Search purchase records by field
	@PostMapping("searchByField")
	public List<PurchaseRecord> searchByField(@RequestBody PurchaseRecordSearchBody purchaseRecordSearchBody) {
		String column = purchaseRecordSearchBody.getField();
		String value = purchaseRecordSearchBody.getValue();
		PurchaseRecordSpecification prs = new PurchaseRecordSpecification(column, value);
		return pruchaseRecordRepository.findAll(prs);
	}
}
