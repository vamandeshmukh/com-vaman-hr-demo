package com.vaman.hr.demo.model;

public class Post {

	private int userId;
	private int id;
	private String itle;
	private String body;

	public Post() {
		super();
	}

	public Post(int userId, int id, String itle, String body) {
		super();
		this.userId = userId;
		this.id = id;
		this.itle = itle;
		this.body = body;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItle() {
		return itle;
	}

	public void setItle(String itle) {
		this.itle = itle;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Post [userId=" + userId + ", id=" + id + ", itle=" + itle + ", body=" + body + "]";
	}

}
