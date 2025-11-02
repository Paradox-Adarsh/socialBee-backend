package com.smb.main.repoositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smb.main.models.UserModel;

public interface UserRepo extends JpaRepository<UserModel, Integer>{
	public UserModel findByEmail(String email);
	
	@Query("SELECT u FROM UserModel u WHERE " +
		       "LOWER(u.firstName) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
		       "LOWER(u.lastName) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
		       "LOWER(u.email) LIKE LOWER(CONCAT('%', :query, '%'))")
	public List<UserModel>searchUser(@Param("query") String query);

}
 	