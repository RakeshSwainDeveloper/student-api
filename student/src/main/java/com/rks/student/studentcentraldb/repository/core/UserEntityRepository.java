package com.rks.student.studentcentraldb.repository.core;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rks.student.studentcentraldb.entity.core.UserEntity;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {

	Optional<UserEntity> findByUserName(String userName);

	@Query(value = "SELECT nextval('core.user_entity_serial_no_seq')", nativeQuery = true)
	Integer getNextUserId();
}