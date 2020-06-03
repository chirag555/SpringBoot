package webapp.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import webapp.entity.Post;

@Service
public class postsService {

	static List<Post> posts = new ArrayList<>(Arrays.asList(new Post(1, "DataType", "Article related to data types"),
			new Post(2, "Classes", "Article related to classes"),
			new Post(3, "Object", "Article related to data Object"),
			new Post(4, "Acces Specifier", "Article related to Acces Specifier"),
			new Post(5, "Refactoring", "Article related to data Refactoring"),
			new Post(6, "Polymorphism", "Article related to Polymorphism")));

	public List<Post> getPosts() {

		return posts;

	}

	public Post getPosts(int id) {

		for (Post post : posts) {
			if (post.getPostId() == id) {
				return post;
			}
		}
		return null;
	}

	public void addPost(Post listElement) {
		posts.add(listElement);

	}

	public void updatePost(Post post, int id) {
		for (Post tpost : posts) {
			if (tpost.getPostId() == id) {
				tpost.setBody(post.getBody());
				tpost.setTitle(post.getTitle());

			}
		}

	}

	public void deletePost(int id) {
		for (Post tpost : posts) {
			if (tpost.getPostId() == id) {
				posts.remove(tpost);
				return;
			}
		
	}
	}
}