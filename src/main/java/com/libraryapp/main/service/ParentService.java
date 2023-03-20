package com.libraryapp.main.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryapp.main.entity.ParentEntity;
import com.libraryapp.main.model.Parent;
import com.libraryapp.main.repository.IParentRepository;

@Service
public class ParentService implements IParentService{
@Autowired
private IParentRepository parentRepository;
	@Override
	public Parent saveParent(Parent parent) {
		ParentEntity parentEntity=new ParentEntity();
		BeanUtils.copyProperties(parent, parentEntity);
		 ParentEntity newParentEntity=parentRepository.save(parentEntity);
		 Parent newParent=new Parent();
		 BeanUtils.copyProperties(newParentEntity,newParent);
		return newParent;
	}

	@Override
	public List<Parent> viewAllParents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Parent getParentByMembershipTypeId(int membershipTypeId) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
