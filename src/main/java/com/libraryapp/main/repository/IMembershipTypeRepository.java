package com.libraryapp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libraryapp.main.entity.MembershipTypeEntity;
@Repository

public interface IMembershipTypeRepository extends JpaRepository<MembershipTypeEntity, Integer> {

}
