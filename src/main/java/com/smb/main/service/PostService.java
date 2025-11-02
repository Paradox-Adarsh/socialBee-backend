package com.smb.main.service;

import java.util.List;

import com.smb.main.models.PostModel;



public interface PostService {

	PostModel createNewPost(PostModel post, Integer useId) throws Exception;

	String deletePost(Integer postId, Integer id) throws Exception;

	List<PostModel> findPostBYUserId(Integer postId) ;

	PostModel findPostbyId(Integer id) throws Exception;

	List<PostModel> findAllPost();

	PostModel likePost(Integer postId, Integer userId) throws Exception;

	PostModel savePost(Integer postId, Integer userId);
}
