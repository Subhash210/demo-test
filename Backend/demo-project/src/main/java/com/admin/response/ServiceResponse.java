/**
 * 
 */
package com.admin.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 */
public class ServiceResponse {

	@JsonProperty(index = 0)
	private Integer status;

	@JsonProperty(index = 1)
	private String title;

	public ResponseEntity<Object> build(String title, Integer status) {

		this.status = status;
		this.title = title;

		return new ResponseEntity<>(this, HttpStatus.valueOf(status));
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
