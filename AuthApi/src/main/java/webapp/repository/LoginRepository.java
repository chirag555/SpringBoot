package webapp.repository;

import org.springframework.data.repository.CrudRepository;
import webapp.entity.Login;

public interface LoginRepository extends CrudRepository<Login,Integer> {

	//@Query(value = "from login where username=:username and password=:password")
	public Login findByUsername(String username);
}
