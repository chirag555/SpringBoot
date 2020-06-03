package webapp.repository;

import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import webapp.entity.Logger;

public interface LoggerClassRepository extends CrudRepository<Logger,Integer>{
	
	public List<Logger> findByentityName(String entityName);
	
	//@Query("SELECT logger.id FROM blog.logger logger WHERE logger.createdDate >= :startDate AND createdDate <= :endDate")
	@Query(value = "from Logger l where createdDate BETWEEN :startDate AND :endDate")
	 List<Logger> findAllBycreatedDate(@PathParam("startDate") Date startDate,@PathParam("endDate") Date endDate);
	                    
}
