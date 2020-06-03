package webapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import webapp.entity.Post;
import webapp.services.PostsService;

@RestController
@RequestMapping("/posts")
public class PostsController {

	@Autowired
	private PostsService postService;
	String url="http://localhost:8080/loggers/";
	RestTemplate restTemplate=new RestTemplate();
	Post tempPost=new Post();
	HttpHeaders httpHeaders=restTemplate.headForHeaders(url);
	HttpEntity<Post> request = new HttpEntity<>(new Post());
	@GetMapping("/")
	public List<Post> getPost() {
		return postService.getPosts();
	}

	@GetMapping("/{id}")
	public Post getPost(@PathVariable int id) {
		return postService.getPosts(id);
	}

	@PostMapping
	public ResponseEntity<Post> addPost(@RequestBody Post post) {
		
		postService.addPost(post);
		restTemplate.postForObject(url, request, Post.class);
		return ResponseEntity.accepted().body(post);
		
		
		}

	@PutMapping
	public ResponseEntity<Post> updatePost(@RequestBody Post post) {
		
		postService.updatePost(post);
		return ResponseEntity.accepted().body(post);
		
		
		
	}

	@DeleteMapping("/{id}")
	public void updatePost(@PathVariable int id) {
		postService.deletePost(id);
	}

}
