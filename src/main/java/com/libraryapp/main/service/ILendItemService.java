package com.libraryapp.main.service;

import java.util.List;

import com.libraryapp.main.model.LendItem;

public interface ILendItemService {
	
	public LendItem insertLendItem(LendItem lendItem);
	public LendItem updateLendItem(LendItem lendItem);
	public void deleteLendItem(int lendId);
	public List<LendItem> viewAllLendings();

}
