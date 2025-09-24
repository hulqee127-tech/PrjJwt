package com.green.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.green.demo.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	// 해당 아이디(usernmae) 가 존재하는지 ㅔ
	Boolean existsByUsername(String username);

}
