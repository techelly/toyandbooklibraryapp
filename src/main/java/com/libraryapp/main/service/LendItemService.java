package com.libraryapp.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryapp.main.entity.LendItemEntity;
import com.libraryapp.main.exception.ResourceNotFoundException;
import com.libraryapp.main.model.LendItem;
import com.libraryapp.main.repository.ILendItemRepository;

@Service
public class LendItemService implements ILendItemService {

	@Autowired
	ILendItemRepository lendItemRepository;

	@Override
	public LendItem insertLendItem(LendItem lendItem) {
		// convert lenditem model to lenditem entity

		LendItemEntity lendItemEntity = new LendItemEntity();
		BeanUtils.copyProperties(lendItem, lendItemEntity);

		LendItemEntity newLendItemEntity = lendItemRepository.save(lendItemEntity);
		// covert lendItem entity to lendItem model

		LendItem newLendItem = new LendItem();
		BeanUtils.copyProperties(newLendItemEntity, newLendItem);

		return newLendItem;

	}

	@Override
	public LendItem updateLendItem(LendItem lendItem) {
		//Find lendItem in database by lendItemId
		Optional<LendItemEntity> lendItemEntity =lendItemRepository.findById(lendItem.getLendId());
		if(lendItemEntity.isPresent()) {
			// convert lenditem model to lenditem entity
			LendItemEntity lenItemEntity = new LendItemEntity();
			BeanUtils.copyProperties(lendItem, lendItemEntity);
			
			LendItemEntity newLendItemEntity = lendItemRepository.save(lenItemEntity);
			// covert lend item  entity to lend item  model

			LendItem newLendItem = new LendItem();
			BeanUtils.copyProperties(newLendItemEntity, newLendItem);

			return newLendItem;

		}else {
			throw new ResourceNotFoundException("lendId "+lendItem.getLendId()+"  not found! Unable to update");
		}

	}

	@Override
	public void deleteLendItem(int lendId) {
		Optional<LendItemEntity> lendItemEntity =lendItemRepository.findById(lendId);
		if(lendItemEntity.isPresent()) {
		lendItemRepository.deleteById(lendId);
		}else {
			throw new ResourceNotFoundException("lendId "+lendId+"  not found! Unable to delete");
		}
	}

	@Override
	public List<LendItem> viewAllLendings() {
		
		List<LendItemEntity> lendItemEntities=lendItemRepository.findAll();
		//convert lendItem entity list to lendItem list
		List<LendItem> lendItems=new ArrayList<>();
		lendItemEntities.forEach(pentity->{
			LendItem lendItem=new LendItem();
			BeanUtils.copyProperties(pentity, lendItem);
			lendItems.add(lendItem);
		});
		return lendItems;
	}

}
