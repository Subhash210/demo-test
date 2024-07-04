/**
 * 
 */
package com.admin.response;

import java.util.List;

/**
 * 
 */
public class EmployeeServiceResponse extends ServiceResponse {

	List<EmployeeResponse> employeeDetails;

	public List<EmployeeResponse> getEmployeeDetails() {
		return employeeDetails;
	}

	public void setEmployeeDetails(List<EmployeeResponse> employeeDetails) {
		this.employeeDetails = employeeDetails;
	}

}
