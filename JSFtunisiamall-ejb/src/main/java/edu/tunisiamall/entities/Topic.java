package edu.tunisiamall.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
public class Topic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTopic;

	private String title;

	@OneToMany(mappedBy = "topic")
	private List<Post> posts;

	public Topic() {
	}

	public int getIdTopic() {
		return idTopic;
	}

	public void setIdTopic(int idTopic) {
		this.idTopic = idTopic;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public int hashCode() {
		return this.idTopic;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Topic))
			return false;
		Topic other = (Topic) obj;
		if (idTopic != other.idTopic)
			return false;
		return true;
	}
	
	

}