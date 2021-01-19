package com.apiproj.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiproj.entity.Friend;
import com.apiproj.repository.FriendRepository;

//Holds the business logic

@Service
public class FriendServices {
	
	@Autowired
	private FriendRepository repository;
	
	public List<Friend> getAllFriends() {
		return repository.findAll();
	}
	
	public Optional<Friend> getFriendById(Integer id) {
		return repository.findById(id);
	}
	
	public void addFriend(Friend friend) {
		repository.save(friend);
	}
	
	public Friend updateFriendById(Friend friend, Integer id) {
		
		Friend existingFriend = repository.findById(id).orElse(null);
		
		existingFriend.setFirstname(friend.getFirstname());
		existingFriend.setLastname(friend.getLastname());
		existingFriend.setEmail(friend.getEmail());
		existingFriend.setDepartment(friend.getDepartment());
		existingFriend.setCountry(friend.getCountry());
		
		return repository.save(existingFriend);
	}
	
	
	public void deleteFriend(Integer id) {
		repository.deleteById(id);
	}
}
