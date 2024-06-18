package com.tao.taodemo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tao.taodemo.model.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long>{
	
	@Modifying
	@Query("INSERT INTO app_user (username, role, password) VALUES (:username, :role, :password) ")
	int addUser(@Param("username") String userName, @Param("role") String role, @Param("password") String password);
	
	@Query("SELECT * FROM app_user")
	List<AppUser> findAllUsers(@Param("username") String userName);
	
	@Query("SELECT * FROM app_user a WHERE a.username > :username ")
	List<AppUser> findByUserName(@Param("username") String userName);
	
	@Query("SELECT * FROM app_user a WHERE a.username = :username AND a.password = :password")
	List<AppUser> findByUserNameAndPassword(@Param("username") String userName, @Param("password") String password);
	
	@Modifying
	@Query("UPDATE app_user SET role = :role, password = :password WHERE username = :username")
	int updateUser(@Param("username") String userName, @Param("role") String role, @Param("password") String password);

	
}
