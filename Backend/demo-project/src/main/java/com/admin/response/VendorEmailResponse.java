/**
 * 
 */
package com.admin.response;

/**
 * 
 */
public class VendorEmailResponse {

	private Long id;

	// Can include the sender details basically admin details. For this task since
	// we are just mocking the email client I am not including the sender details

	private VendorDetailsResponse recipient;

	private String subject;

	private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public VendorDetailsResponse getRecipient() {
		return recipient;
	}

	public void setRecipient(VendorDetailsResponse recipient) {
		this.recipient = recipient;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
