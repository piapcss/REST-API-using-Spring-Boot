package com.apiproj.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.apiproj.entity.Friend;
import com.apiproj.services.FriendServices;

//Controls the requests and responses

@CrossOrigin("*")
@RestController
public class FriendsController {
	
	@Autowired
	private FriendServices service;
	
	
	@GetMapping("/friends")
	public List<Friend> getAllFriends() {
		return service.getAllFriends();
	}
	
	@GetMapping("/friends/view/{id}")
	public Optional<Friend> getFriendById(@PathVariable Integer id) {
		return service.getFriendById(id);
	}
	
	@PostMapping("/friends/add")
	public void addFriend(@RequestBody Friend friend) {
		service.addFriend(friend);
	}
	
	@PutMapping("/friends/update/{id}") 
	public void updateFriend(@PathVariable Integer id, 
			@RequestBody Friend friend) {
		service.updateFriendById(friend, id);
	}
	
	@DeleteMapping("/friends/delete/{id}")
	public void deleteFriend(@PathVariable Integer id) {
		service.deleteFriend(id);
	}
	
}
