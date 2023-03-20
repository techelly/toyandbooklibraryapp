package com.libraryapp.main.service;

import java.util.List;

import com.libraryapp.main.model.Parent;

public interface IParentService {
	public Parent saveParent(Parent parent);
	public List<Parent> viewAllParents();
	public Parent getParentByMembershipTypeId(int membershipTypeId);

}
