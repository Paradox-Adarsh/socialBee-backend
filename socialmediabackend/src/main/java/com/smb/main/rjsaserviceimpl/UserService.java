package com.smb.main.rjsaserviceimpl;

import java.util.List;

import com.smb.main.rjsaModels.UserModel;

public interface UserService {
	public UserModel register(UserModel user) ;
	public UserModel fineUserById(Integer userId) throws Exception;
	public UserModel findUserByEmail(String email);
	public UserModel followUser(Integer userId,Integer userId2) throws Exception;
	public UserModel updateUser(UserModel user,Integer id) throws Exception;
//	public List<UserModel>searchUser(String query);
	

}
