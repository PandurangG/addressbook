package com.example.addressbook.db.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonManagedReference
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<AddressBook> addressBook = new HashSet<>();


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<AddressBook> getAddressBook() {
		return addressBook;
	}

	public void setAddressBook(Set<AddressBook> addressBook) {
		this.addressBook = addressBook;
	}
	
	public void addAddressBook(AddressBook addressBook){
		this.addressBook.add(addressBook);
	}
	
	public void addAddressBooks(Collection<AddressBook> addressBook){
		if(addressBook != null){
			addressBook.stream()
			.forEach(ab -> {
				addAddressBook(ab);
			});
		}
	}

}
