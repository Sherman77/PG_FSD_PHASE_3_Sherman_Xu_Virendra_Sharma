package com.ecommerce.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.ecommerce.model.PurchaseRecord;

public class PurchaseRecordSpecification implements Specification<PurchaseRecord>{
	
	private String column;
	private String value;
	
	public PurchaseRecordSpecification(String column, String value) {
		super();
		this.column = column;
		this.value = value;
	}

	@Override
	public Predicate toPredicate(Root<PurchaseRecord> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		// TODO Auto-generated method stub
		return builder.and(builder.equal(root.<String>get(this.column), this.value));
	}
	
	

}
