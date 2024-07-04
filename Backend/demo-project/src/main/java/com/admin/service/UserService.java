/**
 * 
 */
package com.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.admin.request.EmailRequest;
import com.admin.request.EmployeeRequest;
import com.admin.request.VendorRequest;
import com.admin.response.EmployeeResponse;
import com.admin.response.VendorResponse;

/**
 * UserService interface provides methods for managing employees and vendors, as
 * well as sending emails.
 * 
 * <p>
 * This service includes operations for creating employees and vendors,
 * retrieving employee and vendor details, and sending emails.
 * </p>
 */
@Service
public interface UserService {

	/**
	 * Creates a new employee.
	 *
	 * @param employeeRequest the request containing employee details
	 */
	void createEmployee(EmployeeRequest employeeRequest);

	/**
	 * Creates a new vendor.
	 *
	 * @param vendorRequest the request containing vendor details
	 */
	void createVendor(VendorRequest vendorRequest);

	/**
	 * Retrieves vendor details.
	 *
	 * @param isEmailData if true, includes email-related data in the response
	 * @return the response containing vendor details
	 */
	VendorResponse getVendorDetails(Boolean isEmailData);

	/**
	 * Retrieves a list of employee details.
	 *
	 * @return a list of responses containing employee details
	 */
	List<EmployeeResponse> getEmployeeDetails();

	/**
	 * Sends an email.
	 *
	 * @param emailRequest the request containing email details
	 */
	void sendEmail(EmailRequest emailRequest);

}
