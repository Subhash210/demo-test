/**
 * 
 */
package com.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.entity.EmployeeEntity;

/**
 * 
 * employee repository class to handle crud operations for employee
 * 
 */
public interface EmployeeRespository extends JpaRepository<EmployeeEntity, Integer> {

	EmployeeEntity findByEmail(String email);

}
