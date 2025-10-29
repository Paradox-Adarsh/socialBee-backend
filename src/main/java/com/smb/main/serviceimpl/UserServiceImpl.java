package com.smb.main.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smb.main.models.UserModel;
import com.smb.main.repoositories.UserRepo;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepo repo;
	
	@Override
	public UserModel register(UserModel user) {
		

		UserModel newUser = new UserModel();
		newUser.setId(user.getId());
		newUser.setFirstName(user.getFirstName());
		newUser.setEmail(user.getEmail());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setPassword(user.getPassword());
		UserModel savedUser=repo.save(newUser);
		return savedUser;
		
	}

	@Override
	public UserModel fineUserById(Integer userId) throws Exception {
		Optional<UserModel>user=repo.findById(userId);
		if(user.isPresent()) {
			return user.get();
		}
	
		throw new Exception("user not exist with userId" +userId);
		
		}

	@Override
	public UserModel findUserByEmail(String email) {
		UserModel user=repo.findByEmail(email);
		return user;
		
	}

	@Override
	public UserModel followUser(Integer userId, Integer userId2) throws Exception {
		// TODO Auto-generated method stub
		UserModel user1=fineUserById(userId);
		UserModel user2=fineUserById(userId2);
		 user2.getFollowers().add(userId);
		 user1.getFollowings().add(userId2);
		 
		 repo.save(user1);
		 repo.save(user2);
		 return null;
		 
		 
	}

	@Override
	public UserModel updateUser(UserModel user, Integer Id) throws Exception {
		Optional<UserModel>user1=repo.findById(Id);
		
		if(user1.isEmpty()) {
			throw new Exception("user Does not exist"+ Id);
			
		}
		
		UserModel oldUser=user1.get();
		if(user.getFirstName()!=null) {
			oldUser.setFirstName(user.getFirstName());
		}
		
		if(user.getLastName()!=null) {
			oldUser.setLastName(user.getLastName());
		}
		
		if(user.getEmail()!=null) {
			oldUser.setEmail(user.getEmail());
		}
		
		UserModel updatedUser=repo.save(oldUser);
		
		// TODO Auto-generated method stub
		return updatedUser;
	}
	
	
	
	
	

//	@Override
//	public List<UserModel> searchUser(String query) {
//		return repo.searchUser(query);
//		
//	}

}
