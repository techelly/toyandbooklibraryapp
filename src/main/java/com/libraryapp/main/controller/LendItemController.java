package com.libraryapp.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.libraryapp.main.model.LendItem;
import com.libraryapp.main.service.ILendItemService;

@RestController
public class LendItemController {
	@Autowired
	private ILendItemService lendItemService;

	@PostMapping("/lenditem/save")
	public ResponseEntity<LendItem> addLendItem(@RequestBody LendItem lendItem) {
		LendItem newLendItem = lendItemService.insertLendItem(lendItem);
		ResponseEntity<LendItem> responseEntity = new ResponseEntity<>(newLendItem, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/lenditem/all")
	public List<LendItem> getAllLendItem() {
		List<LendItem> lendItems = lendItemService.viewAllLendings();
		return lendItems;
	}
	
	@PutMapping("/lenditem/update")
	public ResponseEntity<LendItem> updateLendItem(@RequestBody LendItem lendItem) {
		LendItem newLendItem =lendItemService.updateLendItem(lendItem);
		ResponseEntity<LendItem> responseEntity = new ResponseEntity<>(newLendItem, HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping("/lenditem/delete/{lendId}")
	public ResponseEntity<String> deleteLendItem(int lendId) {
		lendItemService.deleteLendItem(lendId);
		return new ResponseEntity<String>("Item deleted  successfully",HttpStatus.OK);
	}
}
