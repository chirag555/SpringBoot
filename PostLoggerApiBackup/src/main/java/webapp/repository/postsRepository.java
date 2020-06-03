package webapp.repository;

import org.springframework.data.repository.CrudRepository;
import webapp.entity.Post;

public interface postsRepository extends CrudRepository<Post,Integer> {
	

	
}
