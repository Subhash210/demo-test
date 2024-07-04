/**
 * 
 */
package com.admin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.admin.dao.VendorDao;
import com.admin.entity.VendorEmailEntity;
import com.admin.entity.VendorEntity;
import com.admin.mapper.VendorMapper;
import com.admin.repository.VendorEmailRespository;
import com.admin.repository.VendorRepository;
import com.admin.request.EmailRequest;
import com.admin.request.VendorEmailRequest;
import com.admin.request.VendorRequest;
import com.admin.response.VendorDetailsResponse;
import com.admin.response.VendorEmailResponse;

/**
 * Implementation class for VendorDao interface, responsible for handling data
 * access operations related to vendors and vendor emails using Spring Data JPA.
 */
@Service // Indicates that this class is a Spring service component
public class VendorDaoImpl implements VendorDao {

	@Autowired
	private VendorRepository vendorRepository; // Autowired repository for vendor data access

	@Autowired
	private VendorEmailRespository vendorEmailRespository; // Autowired repository for vendor email data access

	@Autowired
	private VendorMapper vendorMapper; // Autowired mapper to map between request/response objects and entities

	/**
	 * Method to create a new vendor.
	 * 
	 * @param vendorRequest The request object containing vendor details
	 */
	@Override
	public void createVendor(VendorRequest vendorRequest) {
		// Map vendor request to vendor entity using mapper
		VendorEntity vendorEntity = vendorMapper.mapFrom(vendorRequest);
		// Save vendor entity using Spring Data JPA repository
		vendorRepository.save(vendorEntity);
	}

	/**
	 * Method to retrieve a list of vendor details.
	 * 
	 * @return List of VendorDetailsResponse objects representing vendor details
	 */
	@Override
	public List<VendorDetailsResponse> getVendorDetails() {
		List<VendorDetailsResponse> responseList = null; // Initialize list for vendor details responses
		List<VendorEntity> vendorList = vendorRepository.findAll(); // Retrieve all vendors from repository

		// Check if vendor list is not empty
		if (!CollectionUtils.isEmpty(vendorList)) {
			responseList = new ArrayList<>(); // Initialize list for vendor details responses
			// Iterate through each vendor entity and map to vendor details response using
			// mapper
			for (VendorEntity vendorEntity : vendorList) {
				VendorDetailsResponse vendorResponse = vendorMapper.mapResponse(vendorEntity);
				responseList.add(vendorResponse); // Add mapped vendor details response to the list
			}
		}

		return responseList; // Return list of vendor details responses
	}

	/**
	 * Method to retrieve a list of vendor email details.
	 * 
	 * @return List of VendorEmailResponse objects representing vendor email details
	 */
	@Override
	public List<VendorEmailResponse> getVendorEmailDetails() {
		List<VendorEmailResponse> response = null; // Initialize list for vendor email responses
		List<VendorEmailEntity> vendorEmails = vendorEmailRespository.findAll(); // Retrieve all vendor emails from
																					// repository

		// Check if vendor email list is not empty
		if (!CollectionUtils.isEmpty(vendorEmails)) {
			response = new ArrayList<>(); // Initialize list for vendor email responses
			// Iterate through each vendor email entity and map to vendor email response
			// using mapper
			for (VendorEmailEntity vendorEmailEntity : vendorEmails) {
				VendorEmailResponse vendorEmailResponse = vendorMapper.mapEmailResponse(vendorEmailEntity);
				response.add(vendorEmailResponse); // Add mapped vendor email response to the list
			}
		}

		return response; // Return list of vendor email responses
	}

	/**
	 * Method to save email details for vendors.
	 * 
	 * @param emailRequest The request object containing email details
	 */
	@Override
	public void saveEmailDetails(EmailRequest emailRequest) {
		List<VendorEmailEntity> emails = new ArrayList<>(); // Initialize list for vendor email entities

		// Check if email request is not empty
		if (!CollectionUtils.isEmpty(emailRequest.getEmailRequest())) {
			// Iterate through each email request and map to vendor email entity using
			// mapper
			for (VendorEmailRequest email : emailRequest.getEmailRequest()) {
				VendorEmailEntity sentEmail = vendorMapper.mapSentEmail(email);
				// Set recipient by finding vendor entity based on email address
				sentEmail.setRecipient(vendorRepository.findByEmail(email.getTo()));
				emails.add(sentEmail); // Add mapped vendor email entity to the list
			}

			vendorEmailRespository.saveAll(emails); // Save all vendor email entities
		}
	}

}
