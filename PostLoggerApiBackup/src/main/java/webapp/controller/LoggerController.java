package webapp.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import webapp.entity.Logger;
import webapp.services.LoggerService;
@RestController
@RequestMapping("/loggers")
public class LoggerController {
	
	@Autowired
	private LoggerService loggerService;
	
	@GetMapping("/")
	public List<Logger> getLogger(){
		return loggerService.getLogger();
	}
	@PostMapping("/")
	public void addLogger(@RequestBody Logger listElement) {
		loggerService.addLogger(listElement);
		
	}
	
	@GetMapping("/{id}")
	public Logger getLogger(@PathVariable int id){		
		return loggerService.getLogger(id);
	}
	
	@GetMapping("/entity/{entityName}")
	public List<Logger> getLogger(@PathVariable String entityName){		
		return loggerService.getLoggerByEntityName(entityName);
	}
	
	@GetMapping("/bydate/{startDate}/{endDate}")
	public List<Logger> getLoggerByDate(@PathVariable String startDate,@PathVariable String endDate){		
		return loggerService.getLoggerByDate(startDate,endDate);
	}	
	
	@GetMapping()
	public ResponseEntity<?> getProgramById( @RequestParam(value = "startDate", required = false) Date startDate,@RequestParam(value = "endDate", required = false) Integer endDate) {
		return null;}
	
}
