package com.ecommerce.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.ecommerce.model.Product;

public class ProductSpecification implements Specification<Product>{
	
	private String column;
	private String value;
	
	public ProductSpecification(String productColumn, String productValue) {
		this.column = productColumn;
		this.value = productValue;
	}

	@Override
	public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		// TODO Auto-generated method stub
		return builder.and(builder.equal(root.<String>get(this.column), this.value));
	}
	
	
}
