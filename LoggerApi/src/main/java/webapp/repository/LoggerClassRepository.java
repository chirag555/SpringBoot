package webapp.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import webapp.entity.Logger;

public interface LoggerClassRepository extends CrudRepository<Logger,Integer>{
	
	public List<Logger> findByentityName(String entityName);
	
	
	@Query(value = "from Logger where createdDate BETWEEN :startDate AND :endDate")
	/// List<Logger> findAllBycreatedDate(@PathParam("startDate") Date startDate,@PathParam("endDate") Date endDate);
	 List<Logger> findAllBycreatedDate(Date startDate, Date endDate);
	                    
}
