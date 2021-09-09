package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ecommerce.model.PurchaseRecord;

public interface PurchaseRecordRepository extends JpaRepository<PurchaseRecord, Integer>, JpaSpecificationExecutor<PurchaseRecord>{

}
