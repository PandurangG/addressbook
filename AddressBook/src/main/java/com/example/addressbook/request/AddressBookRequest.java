package com.example.addressbook.request;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressBookRequest {
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("phoneNumber")
	private String phoneNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
