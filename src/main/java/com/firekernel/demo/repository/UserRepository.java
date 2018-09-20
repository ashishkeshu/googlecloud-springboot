package com.firekernel.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.firekernel.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT user FROM User user WHERE email = :email")
	User getUserByEmail(@Param("email") String email);

	@Query("SELECT user FROM User user WHERE email = :email AND user.password = :password")
	User getUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);

	@Query("SELECT user FROM User user WHERE contactNumber = :contactNumber")
	User getUserByContactNumber(@Param("contactNumber") String contactNumber);

	@Query("SELECT user from User user WHERE fbId = :fbId")
	User getUserByFbId(@Param("fbId") String fbId);

	@Query("SELECT user FROM User user WHERE googleId = :googleId")
	User getUserByGoogleId(@Param("googleId") String googleId);

}
