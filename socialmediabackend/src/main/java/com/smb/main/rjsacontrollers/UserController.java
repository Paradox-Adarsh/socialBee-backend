package com.smb.main.rjsacontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smb.main.rjsaModels.UserModel;
import com.smb.main.rjsaserviceimpl.UserService;

@RestController
@RequestMapping("/spm")
public class UserController {

	@Autowired
	UserService serv;

	@PostMapping("/rgeisterUser")
	public UserModel createUser(@RequestBody UserModel user) {
		UserModel newUser = serv.register(user);
		return newUser;

	}

	@PutMapping("/update/{userId}")
	public UserModel updateUser(@RequestBody UserModel user, @PathVariable("userId") Integer id) throws Exception {

		UserModel updatedUser = serv.updateUser(user, id);
		return updatedUser;

	}

	@GetMapping("/user/{userid}")
	public UserModel getUserById(@PathVariable("userid") Integer id) throws Exception {

		UserModel user1 = serv.fineUserById(id);

		return user1;

	}

	@PutMapping("/users/follow/{userId},{userId2}")
	public UserModel followUserHandler(@PathVariable Integer userId, @PathVariable Integer userId2) throws Exception {
		UserModel user = serv.followUser(userId, userId2);
		return user;
	}

//	@GetMapping("/users/search")
//	public List<UserModel>searchUsers(@RequestParam("query")String query){
//		List<UserModel>users=serv.searchUser(query);
//		return users;
//	}

}
