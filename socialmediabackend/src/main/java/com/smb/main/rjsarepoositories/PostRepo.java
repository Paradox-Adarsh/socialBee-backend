package com.smb.main.rjsarepoositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.smb.main.rjsaModels.PostModel;


public interface PostRepo extends JpaRepository<PostModel, Integer> {
	@Query("select p from PostModel p where p.user.id=:userId")
	List<PostModel>findPostByUserId(Integer userId);

}
