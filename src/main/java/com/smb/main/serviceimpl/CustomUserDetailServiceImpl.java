package com.smb.main.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.smb.main.models.UserModel;
import com.smb.main.repoositories.UserRepo;


@Service
public class CustomUserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepo repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserModel user=repo.findByEmail(username);
		
		if(user==null) {
			throw new UsernameNotFoundException("user not found with email");
		}
		
	
			List<GrantedAuthority>authorities=new ArrayList<GrantedAuthority>();
		
		
		return new User(user.getEmail(),user.getPassword(),authorities);
	}

}
