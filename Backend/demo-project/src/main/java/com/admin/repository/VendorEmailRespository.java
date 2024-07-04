/**
 * 
 */
package com.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.admin.entity.VendorEmailEntity;

/**
 * 
 * vendor email repository class to handle crud operations for vendor email
 * 
 */
@Repository
public interface VendorEmailRespository extends JpaRepository<VendorEmailEntity, Integer>{
	
	
}
