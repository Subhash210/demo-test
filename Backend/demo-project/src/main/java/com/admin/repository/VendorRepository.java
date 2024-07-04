/**
 * 
 */
package com.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.admin.entity.VendorEntity;

/**
 * 
 * vendor repository class to handle crud operations for vendor
 * 
 */
@Repository
public interface VendorRepository extends JpaRepository<VendorEntity, Integer> {

	/**
	 * 
	 * Method to fetch the data by email
	 * 
	 * @param to recepeint email id
	 * @return
	 */
	VendorEntity findByEmail(String to);

}
