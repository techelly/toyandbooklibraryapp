package com.libraryapp.main.service;

import java.util.List;

import com.libraryapp.main.model.MembershipType;

public interface IMembershipTypeService {
	public MembershipType saveMembershipType(MembershipType membershipType);
	public List<MembershipType> viewAllMembershipTypes();
	public MembershipType viewMembershipTypeById(int membershiptypeId);
	

}
