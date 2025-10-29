package com.smb.main.models;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "posts")
public class PostModel {

	public PostModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostModel(Integer id, String caption, String image, UserModel user, String video, LocalDateTime createdAt,
			List<UserModel> like) {
		super();
		this.id = id;
		this.caption = caption;
		this.image = image;
		this.user = user;
		this.video = video;
		this.createdAt = createdAt;
		this.like = like;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String caption;
	private String image;
	
	@ManyToOne
	private UserModel user;
	private String video;
	private LocalDateTime createdAt;
	
	
	@OneToMany
	private List<UserModel> like;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public List<UserModel> getLike() {
		return like;
	}

	public void setLike(List<UserModel> like) {
		this.like = like;
	}

}
