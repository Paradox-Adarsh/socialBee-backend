package com.smb.main.rjsacontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smb.main.rjsaModels.PostModel;
import com.smb.main.rjsaserviceimpl.PostService;
import com.smb.main.rrjsaresponse.ApiResponse;

@RestController
public class PostController {

	@Autowired
	PostService postServ;

	@PostMapping("/post/user/{id}")
	public ResponseEntity<PostModel> createPost(@RequestBody PostModel post, @PathVariable Integer id)
			throws Exception {

		PostModel createPost = postServ.createNewPost(post, id);
		return new ResponseEntity<>(createPost, HttpStatus.ACCEPTED);	

	}

	@DeleteMapping("/post/{postid}/user/{userId}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable("postId") Integer postId,
			@PathVariable("userId") Integer userId) throws Exception {

		String message = postServ.deletePost(postId, userId);
		ApiResponse response = new ApiResponse(message, true);

		return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);

	}

	@GetMapping("/post/{postId}")
	public ResponseEntity<PostModel> findPostByHandler(@PathVariable Integer userId) throws Exception {
		PostModel post = postServ.findPostbyId(userId);

		return new ResponseEntity<PostModel>(post, HttpStatus.ACCEPTED);

	}
	@GetMapping("posts/user/{userId}")
	public ResponseEntity<List<PostModel>>findUserPost(@PathVariable Integer userId){
		List<PostModel>posts=postServ.findPostBYUserId(userId);
		return new ResponseEntity<List<PostModel>>(posts,HttpStatus.OK);
	}
	
	
	@GetMapping("/posts")
	public ResponseEntity<List<PostModel>>findAllPost(){
		List<PostModel>posts=postServ.findAllPost();
		return new ResponseEntity<List<PostModel>>(posts,HttpStatus.OK);
	}
	
	@PutMapping("/post/{postid}/user/{userId}")
	public ResponseEntity<PostModel> savePost(@PathVariable("postId") Integer postId,
			@PathVariable("userId") Integer userId) throws Exception {

		PostModel post=postServ.savePost(postId, userId);

		return new ResponseEntity<PostModel>(post, HttpStatus.OK);

	}
	@PutMapping("/post/like/{postid}/user/{userId}")
	public ResponseEntity<PostModel> likePost(@PathVariable("postId") Integer postId,
			@PathVariable("userId") Integer userId) throws Exception {
		
		PostModel post=postServ.likePost(postId, userId);
		
		return new ResponseEntity<PostModel>(post, HttpStatus.OK);
		
	}
	
	

}
