package com.smb.main.rjsaserviceimpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smb.main.rjsaModels.PostModel;
import com.smb.main.rjsaModels.UserModel;
import com.smb.main.rjsarepoositories.PostRepo;
import com.smb.main.rjsarepoositories.UserRepo;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostRepo postRepo;

	@Autowired
	UserService userServ;

	@Autowired
	UserRepo userRepo;

	@Override
	public PostModel createNewPost(PostModel post, Integer userId) throws Exception {

		UserModel user = userServ.fineUserById(userId);

		PostModel newPost = new PostModel();
		newPost.setCaption(post.getCaption());
		newPost.setVideo(post.getVideo());
		newPost.setImage(post.getImage());
		newPost.setUser(user);
		newPost.setCreatedAt(LocalDateTime.now());

		return postRepo.save(newPost);
	}

	@Override
	public String deletePost(Integer postId, Integer id) {
		PostModel post = null;
		UserModel user = null;

		try {
			post = findPostbyId(postId);
			user = userServ.fineUserById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return "Error: " + e.getMessage();
		}

		if (post.getUser().getId() != user.getId()) {
			return "Unable to perform Action";
		}

		postRepo.delete(post);
		return "Post Deleted Successfully";
	}

	@Override
	public List<PostModel> findPostBYUserId(Integer postId) {

		return postRepo.findPostByUserId(postId);
	}

	@Override
	public PostModel findPostbyId(Integer id) throws Exception {
		Optional<PostModel> post = postRepo.findById(id);

		if (post.isEmpty()) {
			throw new Exception("Post Does Not Exist");
		}
		return post.get();
	}

	@Override
	public List<PostModel> findAllPost() {
		return postRepo.findAll();
	}

	@Override
	public PostModel likePost(Integer postId, Integer userId) {
		PostModel post = null;
		UserModel user = null;
		try {
			post = findPostbyId(postId);
			user = userServ.fineUserById(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (post.getLike().contains(user)) {
			post.getLike().remove(user);
		}
		post.getLike().add(user);
		return post;
	}

	@Override
	public PostModel savePost(Integer postId, Integer userId) {
		PostModel post = null;
		UserModel user = null;
		try {
			post = findPostbyId(postId);
			user = userServ.fineUserById(userId);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (user.getSavedPost().contains(post)) {
			user.getSavedPost().remove(post);
		}

		else {
			user.getSavedPost().add(post);
		}
		userRepo.save(user);
		return post;

	}

}
