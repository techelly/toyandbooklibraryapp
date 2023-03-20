package com.libraryapp.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.libraryapp.main.model.MembershipType;
import com.libraryapp.main.model.Parent;
import com.libraryapp.main.service.IParentService;

@RestController
public class ParentController {
	@Autowired
	private IParentService parentService;

	@PostMapping("/parent/save")
	public ResponseEntity<Parent> addParent(@RequestBody Parent parent) {
		Parent newParent = parentService.saveParent(parent);
		ResponseEntity<Parent> responseEntity = new ResponseEntity<>(newParent, HttpStatus.CREATED);
		return responseEntity;

	}

}
