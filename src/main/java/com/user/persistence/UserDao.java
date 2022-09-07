package com.user.persistence;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.user.bean.User;

@Repository
public interface UserDao extends JpaRepository<User, String> {
	Optional<User> findByEmail(String email);
	
	@Transactional
	@Modifying
	@Query(value = "insert into user(email, name, contact) values(:email, :name, :contact)", nativeQuery = true)
	int addUser(@Param("email") String email, @Param("name") String name, @Param("contact") long contact);
}