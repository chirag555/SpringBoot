package webapp.services;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.WebServiceClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import webapp.entity.Post;
import webapp.repository.postsRepository;

@Service
public class PostsService {

	@Autowired
	private postsRepository repo;
	RestTemplate restTemplate=new RestTemplate();
	Post tempPost=new Post();
	public List<Post> getPosts() {
		List<Post> posts = new ArrayList<>();
		for (Post post : repo.findAll()) {
			posts.add(post);
		}
		return posts;
	}
	public Post getPosts(int id) {
		return repo.findById(id).get();

	}

	public void addPost(Post listElement) {	
		//String uri="http://localhost:8080/loggers/";
		
		repo.save(listElement);

	}

	public void updatePost(Post post) {
		tempPost=repo.findById(post.getId()).get();
		post.setCreatedDate(tempPost.getCreatedDate());
		post.setDescription(tempPost.getDescription());
		repo.save(post);
	}

	public void deletePost(int id) {
		repo.deleteById(id);
	}

	
	

}