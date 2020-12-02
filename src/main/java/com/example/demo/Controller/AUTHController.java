package com.example.demo.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.AuthService.LoginRequest;
import com.example.demo.AuthService.authService;
import com.example.demo.DAO.user;
import com.example.demo.userService.userService;

@RestController
@RequestMapping("api/user")
public class AUTHController {
	private static final Logger log = LoggerFactory.getLogger(AUTHController.class);

	@Autowired
	private authService authService; 
	@Autowired
	private userService us;
	@PostMapping("/login")
	public String sign_in(@RequestBody LoginRequest login) throws Exception {
	 log.info(login.getPassWord()+"lmk");
		return authService.Login(login.getMail(), login.getPassWord());
	}
	@PostMapping("/sing_up")
	public user sing_up(@RequestBody user user) {
		return us.ajouterUser(user);
		
	}

}
