package com.nuitdelinfo.app.model;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String message;

    @ManyToOne(targetEntity=User.class)
    private User user;
    
    @ManyToOne(targetEntity=Post.class)
    private User post;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Comment [message=");
		builder.append(message);
		builder.append(", user=");
		builder.append(user);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Comment(String message, User user) {
		this.message = message;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
