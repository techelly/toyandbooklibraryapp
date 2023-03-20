package com.libraryapp.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryapp.main.entity.MembershipTypeEntity;
import com.libraryapp.main.model.MembershipType;
import com.libraryapp.main.repository.IMembershipTypeRepository;

@Service

public class MembershipTypeService implements IMembershipTypeService {
	@Autowired
	private IMembershipTypeRepository membershipTypeRepository;

	@Override
	public MembershipType saveMembershipType(MembershipType membershipType) {
		MembershipTypeEntity membershipTypeEntity = new MembershipTypeEntity();
		BeanUtils.copyProperties(membershipType, membershipTypeEntity);

		MembershipTypeEntity newmMembershiptype = membershipTypeRepository.save(membershipTypeEntity);

		MembershipType newMembershipType = new MembershipType();
		BeanUtils.copyProperties(newmMembershiptype, newMembershipType);

		return newMembershipType;
	}

	@Override
	public List<MembershipType> viewAllMembershipTypes() {
		List<MembershipTypeEntity> membershipTypeEntities = membershipTypeRepository.findAll();

		List<MembershipType> membershipTypes = new ArrayList<>();

		membershipTypeEntities.forEach(m -> {
			MembershipType membershipType = new MembershipType();
			BeanUtils.copyProperties(m, membershipType);
			membershipTypes.add(membershipType);

		});

		return membershipTypes;
	}

	@Override
	public MembershipType viewMembershipTypeById(int membershiptypeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
