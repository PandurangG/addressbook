package com.example.addressbook.request;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRequest {
	
	@JsonProperty("addressBook")
	private Set<AddressBookRequest> addressBook;

	public Set<AddressBookRequest> getAddressBook() {
		return addressBook;
	}

	public void setAddressBook(Set<AddressBookRequest> addressBook) {
		this.addressBook = addressBook;
	}
}
