package com.libraryapp.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.libraryapp.main.model.MembershipType;
import com.libraryapp.main.service.IMembershipTypeService;

@RestController
public class MembershipTypeController {
	@Autowired
	private IMembershipTypeService membershipTypeService;

	@PostMapping("/membership/save")
	public ResponseEntity<MembershipType> addMembershiptype(@RequestBody MembershipType membershipType) {
		MembershipType newmembershipType = membershipTypeService.saveMembershipType(membershipType);
		ResponseEntity<MembershipType> responseEntity = new ResponseEntity<>(newmembershipType, HttpStatus.CREATED);
		return responseEntity;
	}

}
