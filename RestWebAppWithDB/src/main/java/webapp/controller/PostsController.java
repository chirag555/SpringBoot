package webapp.controller;


import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import webapp.entity.Post;
import webapp.services.postsService;

@RestController
public class PostsController {

	@RequestMapping("/posts")
	public List<Post> getPost(){
		return new postsService().getPosts();
	}
	@RequestMapping("/posts/{id}")
	public Post getPost(@PathVariable int id){
		return new postsService().getPosts(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/posts")	
	public void addPost(@RequestBody Post listElement) {
		new postsService().addPost(listElement);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/posts/{id}")
	public void updatePost(@RequestBody Post post,@PathVariable int id) {
		new postsService().updatePost(post,id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/posts/{id}")
	public void updatePost(@PathVariable int id) {
		new postsService().deletePost(id);
	}
}
