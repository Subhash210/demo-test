/**
 * 
 */
package com.admin.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.admin.request.EmployeeRequest;
import com.admin.response.EmployeeResponse;

/**
 * Data Access Object (DAO) interface for handling employee-related data operations.
 */
@Service // Indicates that this interface is a Spring service component
public interface EmployeeDao {

    /**
     * Method to create a new employee.
     * 
     * @param employeeRequest The request object containing employee details
     */
    void createEmployee(EmployeeRequest employeeRequest);

    /**
     * Method to retrieve a list of employees.
     * 
     * @return List of EmployeeResponse objects representing employee details
     */
    List<EmployeeResponse> getEmployees();

}