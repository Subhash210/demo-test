/**
 * 
 */
package com.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.admin.dao.EmployeeDao;
import com.admin.dao.VendorDao;
import com.admin.request.EmailRequest;
import com.admin.request.EmployeeRequest;
import com.admin.request.VendorRequest;
import com.admin.response.EmployeeResponse;
import com.admin.response.VendorResponse;
import com.admin.service.UserService;

/**
 * Implementation of the {@link UserService} interface.
 * 
 * <p>This service provides functionality for managing employees and vendors,
 * as well as sending emails.</p>
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private VendorDao vendorDao;

    /**
     * Creates a new employee.
     *
     * @param employeeRequest the request containing employee details
     */
    @Override
    public void createEmployee(EmployeeRequest employeeRequest) {
        employeeDao.createEmployee(employeeRequest);
    }

    /**
     * Creates a new vendor.
     *
     * @param vendorRequest the request containing vendor details
     */
    @Override
    public void createVendor(VendorRequest vendorRequest) {
        vendorDao.createVendor(vendorRequest);
    }

    /**
     * Retrieves vendor details.
     *
     * @param isEmailData if true, includes email-related data in the response
     * @return the response containing vendor details
     */
    @Override
    public VendorResponse getVendorDetails(Boolean isEmailData) {
        VendorResponse vendorResponse = new VendorResponse();

        if (isEmailData) {
            vendorResponse.setVendorEmailResponse(vendorDao.getVendorEmailDetails());
        } else {
            vendorResponse.setVendorDetailResponse(vendorDao.getVendorDetails());
        }

        return vendorResponse;
    }

    /**
     * Retrieves a list of employee details.
     *
     * @return a list of responses containing employee details
     */
    @Override
    public List<EmployeeResponse> getEmployeeDetails() {
        return employeeDao.getEmployees();
    }

    /**
     * Sends an email.
     *
     * @param emailRequest the request containing email details
     */
    @Override
    public void sendEmail(EmailRequest emailRequest) {
        if (!CollectionUtils.isEmpty(emailRequest.getEmailRequest())) {
            emailRequest.getEmailRequest().stream().forEach(email -> {
                System.out.println("Sending email to: " + email.getTo());
                System.out.println("Subject: " + email.getSubject());
                System.out.println("Body:");
                System.out.println(email.getBody());
                System.out.println("Email sent successfully!");
            });
        }

        vendorDao.saveEmailDetails(emailRequest);
    }
}