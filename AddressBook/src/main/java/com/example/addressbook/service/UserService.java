package com.example.addressbook.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.addressbook.db.model.AddressBook;
import com.example.addressbook.db.model.User;
import com.example.addressbook.repository.UserRepository;
import com.example.addressbook.request.AddressBookRequest;
import com.example.addressbook.request.UserRequest;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public User save(UserRequest user) {
		
		User userEntity = new User();
		Set<AddressBook> addressBookEntity = new HashSet<>(); 
		for(AddressBookRequest request : user.getAddressBook()) {
			AddressBook book = new AddressBook();
			book.setName(request.getName());
			book.setPhoneNumber(request.getPhoneNumber());
			book.setUser(userEntity);
			addressBookEntity.add(book);
		}
		userEntity.addAddressBooks(addressBookEntity);
		userEntity.setAddressBook(addressBookEntity);
		return userRepository.save(userEntity);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User addFriend(Long userId, AddressBookRequest friend) {
		User user = getUser(userId);
		AddressBook book = new AddressBook();
		book.setName(friend.getName());
		book.setPhoneNumber(friend.getPhoneNumber());
		user.getAddressBook().add(book);
		return userRepository.save(user);
	}

	public Set<AddressBook> getAddressBook(Long userId) {
		User user = getUser(userId);
		return user.getAddressBook();
	}

	public Set<String> getUniqueFriendFromTwoUsers(Long userId1, Long userId2) {
		User user1 = getUser(userId1);
		User user2 = getUser(userId2);

		Set<String> user1Friends = user1.getAddressBook()
				.stream()
				.map(AddressBook::getName)
				.collect(Collectors.toSet());

		Set<String> user2Friends = user2.getAddressBook()
				.stream()
				.map(AddressBook::getName)
				.collect(Collectors.toSet());

		return getUnionOfFriendsFromTwoAddressBooks(user1Friends, user2Friends);
	}

	private User getUser(Long userId)  {
		User user = null;
		try {
			 user  =  userRepository
					.findUserById(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	private Set<String> getUnionOfFriendsFromTwoAddressBooks(Set<String> usersFriends, Set<String> providedNames) {
		Set<String> result = new HashSet<String>(providedNames);
		for (String name : usersFriends) {
			if (!result.add(name)) {
				result.remove(name);
			}
		}
		return result;
	}

}
