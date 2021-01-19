package com.apiproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apiproj.entity.Friend;

//Communicates with Database

@Repository
public interface FriendRepository extends JpaRepository<Friend, Integer> {}
