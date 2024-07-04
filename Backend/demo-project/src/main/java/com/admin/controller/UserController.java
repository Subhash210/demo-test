package com.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.admin.EmailAlreadyExistsException;
import com.admin.UserValidator;
import com.admin.request.EmailRequest;
import com.admin.request.EmployeeRequest;
import com.admin.request.VendorRequest;
import com.admin.response.EmailErrorResponse;
import com.admin.response.EmployeeResponse;
import com.admin.response.EmployeeServiceResponse;
import com.admin.response.ServiceResponse;
import com.admin.response.VendorResponse;
import com.admin.service.UserService;

/**
 * Controller class for handling user-related operations.
 */
@RestController
@RequestMapping(value = "/api/v0/user") // Base mapping for this controller
@CrossOrigin(origins = "*") // Allows requests from any origin (for CORS)
public class UserController {

	@Autowired
	private UserService userService; // Autowired service dependency

	@Autowired
	private UserValidator userValidator;

	/**
	 * Endpoint to create a new employee.
	 * 
	 * @param employeeRequest The request body containing employee details
	 * @return ResponseEntity with a success message and HTTP status 200
	 * @throws EmailAlreadyExistsException
	 */
	@PostMapping(path = "/create-employee")
	public ResponseEntity<Object> createEmployee(@RequestBody EmployeeRequest employeeRequest)
			throws EmailAlreadyExistsException {

		if (userValidator.isEmailExist(employeeRequest.getEmail(), "Employee")) {
			// throw new EmailAlreadyExistsException("Email already exists: " +
			// employeeRequest.getEmail());

			EmailErrorResponse emailErrorResponse = new EmailErrorResponse();
			emailErrorResponse.setMessage("Email already exists: " + employeeRequest.getEmail());
			return emailErrorResponse.build("Error", 400);
		}
		userService.createEmployee(employeeRequest); // Call service to create employee
		return new ServiceResponse().build("Employee created successfully", 200); // Return success response
	}

	/**
	 * Endpoint to create a new vendor.
	 * 
	 * @param vendorRequest The request body containing vendor details
	 * @return ResponseEntity with a success message and HTTP status 200
	 * @throws EmailAlreadyExistsException
	 */
	@PostMapping(path = "/create-vendor")
	public ResponseEntity<Object> createVendor(@RequestBody VendorRequest vendorRequest)
			throws EmailAlreadyExistsException {

//		if (isEMailExist) {
//			throw new EmailAlreadyExistsException("Email already exists: " + vendorRequest.getEmail());
//		}

		if (userValidator.isEmailExist(vendorRequest.getEmail(), "Vendor")) {
			// throw new EmailAlreadyExistsException("Email already exists: " +
			// employeeRequest.getEmail());

			EmailErrorResponse emailErrorResponse = new EmailErrorResponse();
			emailErrorResponse.setMessage("Email already exists: " + vendorRequest.getEmail());
			return emailErrorResponse.build("Error", 400);
		}

		userService.createVendor(vendorRequest); // Call service to create vendor
		return new ServiceResponse().build("Vendor created successfully", 200); // Return success response
	}

	/**
	 * Endpoint to retrieve vendor details.
	 * 
	 * @param isEmailData Boolean flag indicating whether to include email data
	 * @return ResponseEntity with vendor details and HTTP status 200
	 */
	@GetMapping(path = "/view-vendors")
	public ResponseEntity<Object> getVendorDetails(@RequestParam Boolean isEmailData) {
		VendorResponse vendorResponse = userService.getVendorDetails(isEmailData); // Get vendor details from service
		return vendorResponse.build("Vendors details loaded successfully", 200); // Return response with success message
	}

	/**
	 * Endpoint to retrieve employee details.
	 * 
	 * @return ResponseEntity with employee details and HTTP status 200
	 */
	@GetMapping(path = "/view-employees")
	public ResponseEntity<Object> getEmployeeDetails() {
		List<EmployeeResponse> employeeResponse = userService.getEmployeeDetails(); // Get employee details from service
		EmployeeServiceResponse employeeServiceResponse = new EmployeeServiceResponse();
		employeeServiceResponse.setEmployeeDetails(employeeResponse);
		return employeeServiceResponse.build("Employee details loaded successfully", 200); // Return response with
																							// success message
	}

	/**
	 * Endpoint to send an email.
	 * 
	 * @param emailRequest The request body containing email details
	 */
	@PostMapping(path = "/send-email")
	public void sendEmail(@RequestBody EmailRequest emailRequest) {
		userService.sendEmail(emailRequest); // Call service to send email
	}
}
