/**
 * 
 */
package com.admin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.admin.dao.EmployeeDao;
import com.admin.entity.EmployeeEntity;
import com.admin.mapper.EmployeeMapper;
import com.admin.repository.EmployeeRespository;
import com.admin.request.EmployeeRequest;
import com.admin.response.EmployeeResponse;

/**
 * Implementation class for EmployeeDao interface, responsible for handling data
 * access operations related to employees using Spring Data JPA.
 */
@Service // Indicates that this class is a Spring service component
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EmployeeRespository employeeRespository; // Autowired repository for employee data access

	@Autowired
	private EmployeeMapper employeeMapper; // Autowired mapper to map between request/response objects and entities

	/**
	 * Method to create a new employee.
	 * 
	 * @param employeeRequest The request object containing employee details
	 */
	@Override
	public void createEmployee(EmployeeRequest employeeRequest) {
		// Map employee request to employee entity using mapper
		EmployeeEntity employeeEntity = employeeMapper.mapFrom(employeeRequest);
		// Save employee entity using Spring Data JPA repository
		employeeRespository.save(employeeEntity);
	}

	/**
	 * Method to retrieve a list of employees.
	 * 
	 * @return List of EmployeeResponse objects representing employee details
	 */
	@Override
	public List<EmployeeResponse> getEmployees() {
		List<EmployeeResponse> employeeResponse = new ArrayList<>(); // Initialize empty list for employee responses
		List<EmployeeEntity> employeeList = employeeRespository.findAll(); // Retrieve all employees from repository

		// Check if employee list is not empty
		if (!CollectionUtils.isEmpty(employeeList)) {
			// Iterate through each employee entity and map to employee response using
			// mapper
			for (EmployeeEntity employeeEntity : employeeList) {
				EmployeeResponse employee = employeeMapper.mapResponse(employeeEntity);
				employeeResponse.add(employee); // Add mapped employee response to the list
			}
		}

		return employeeResponse; // Return list of employee responses
	}

}
