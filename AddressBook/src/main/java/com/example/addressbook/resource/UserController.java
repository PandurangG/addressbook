package com.example.addressbook.resource;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.addressbook.db.model.AddressBook;
import com.example.addressbook.db.model.User;
import com.example.addressbook.request.AddressBookRequest;
import com.example.addressbook.request.UserRequest;
import com.example.addressbook.service.UserService;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("user")
    public ResponseEntity<User> createUser(@RequestBody UserRequest user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping("addressbook/{userId}")
    public ResponseEntity<Set<AddressBook>> getAddressBook(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getAddressBook(userId));
    }

    @PostMapping("addressbook")
    public ResponseEntity<User> addFriendToAddressBook(@PathVariable Long userId, @RequestBody AddressBookRequest addressBook) {
        return ResponseEntity.ok(userService.addFriend(userId, addressBook));
    }

    @GetMapping("manage/user")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
    
    @GetMapping("manage/{userId1}/{userId2}")
    public ResponseEntity<Set<String>> getUniqueFriendFromTwoUsers(@PathVariable Long userId1,@PathVariable Long userId2 ) {
        return ResponseEntity.ok(userService.getUniqueFriendFromTwoUsers(userId1,userId2));
    }
    
}
