package webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import webapp.entity.Login;
import webapp.repository.LoginRepository;
import webapp.services.LoginService;


@RestController
public class LoginController {
	
	@Autowired
	LoginService loginService;
	/*
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	*/
	
	@GetMapping("/auth")
	public String authenticateUser( @RequestParam(value ="username", required = false) String username,
			@RequestParam(value ="password", required = false) String password) {
				//loginService.authenticateUser(username, password);
		//return startDate==null ? loggerService.getLogger():loggerService.getLoggerByDate(startDate, endDate);
		//System.out.println(username);
				//return loginService.authenticateUser(username);
		return loginService.authenticateUser(username,password);
	}
		
}
