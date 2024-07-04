/**
 * 
 */
package com.admin.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VendorResponse extends ServiceResponse {

	private List<VendorDetailsResponse> vendorDetailResponse;

	private List<VendorEmailResponse> vendorEmailResponse;

	public List<VendorDetailsResponse> getVendorDetailResponse() {
		return vendorDetailResponse;
	}

	public void setVendorDetailResponse(List<VendorDetailsResponse> vendorDetailResponse) {
		this.vendorDetailResponse = vendorDetailResponse;
	}

	public List<VendorEmailResponse> getVendorEmailResponse() {
		return vendorEmailResponse;
	}

	public void setVendorEmailResponse(List<VendorEmailResponse> vendorEmailResponse) {
		this.vendorEmailResponse = vendorEmailResponse;
	}

}
