/**
 * 
 */
package com.admin.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.admin.request.EmailRequest;
import com.admin.request.VendorRequest;
import com.admin.response.VendorDetailsResponse;
import com.admin.response.VendorEmailResponse;

/**
 * Data Access Object (DAO) interface for handling vendor-related data
 * operations.
 */
@Service // Indicates that this interface is a Spring service component
public interface VendorDao {

	/**
	 * Method to create a new vendor.
	 * 
	 * @param vendorRequest The request object containing vendor details
	 */
	void createVendor(VendorRequest vendorRequest);

	/**
	 * Method to retrieve a list of vendor details.
	 * 
	 * @return List of VendorDetailsResponse objects representing vendor details
	 */
	List<VendorDetailsResponse> getVendorDetails();

	/**
	 * Method to retrieve a list of vendor email details.
	 * 
	 * @return List of VendorEmailResponse objects representing vendor email details
	 */
	List<VendorEmailResponse> getVendorEmailDetails();

	/**
	 * Method to save email details for a vendor.
	 * 
	 * @param emailRequest The request object containing email details
	 */
	void saveEmailDetails(EmailRequest emailRequest);

}
