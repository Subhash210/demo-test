/**
 * 
 */
package com.admin;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.admin.repository.EmployeeRespository;
import com.admin.repository.VendorRepository;

/**
 * 
 */
@Component
public class UserValidator {

	@Autowired
	private EmployeeRespository employeeRespository;

	@Autowired
	private VendorRepository vendorRepository;

	public boolean isEmailExist(String email, String userType) {
	    if (userType.equals("Vendor")) {
	        return ObjectUtils.isNotEmpty(vendorRepository.findByEmail(email));
	    } else {
	        return ObjectUtils.isNotEmpty(employeeRespository.findByEmail(email));
	    }
	}

}
