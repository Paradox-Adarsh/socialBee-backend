package com.smb.main.rjsarepoositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smb.main.rjsaModels.UserModel;

public interface UserRepo extends JpaRepository<UserModel, Integer>{
	public UserModel findByEmail(String email);
	
//	@Query("Select u from UserModel u where u.firsName LIKE%:query% OR u.lastName LIKE%:query% OR u.email LIKE%:query%")
//	public List<UserModel>searchUser(@Param("query") String query);

}
 	