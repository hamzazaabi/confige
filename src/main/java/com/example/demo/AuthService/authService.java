package com.example.demo.AuthService;

import java.security.Principal;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.user;
import com.example.demo.Excpetion.NotFoundUserException;
import com.example.demo.configSecurite.useToken;
import com.example.demo.userService.userRepository;
import com.example.demo.userService.userService;

@Service
public class authService {
	private static final Logger log = LoggerFactory.getLogger(authService.class);
	@Autowired
	private userService us;
	@Autowired
	private useToken utoken;
	@Autowired
	private MyUserDetailsService userdetailsimpl;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private userRepository ur;

	/**
	 * @param email
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public String Login(String email, String password) throws Exception {
		user u = us.findUserByemail(email);
		if (u == null)
			throw new NotFoundUserException("4001");
		if (u != null && u.isEnable() == false)
			throw new IllegalStateException("user n'est pas verifier");
		/*
		 * log.info(utoken.getUserNameFromJwtToken(
		 * utoken.generateJwtToken(SecurityContextHolder.getContext().getAuthentication(
		 * )))); log.info("11"); return
		 * utoken.generateJwtToken(SecurityContextHolder.getContext().getAuthentication(
		 * ));
		 */
		try {
			log.info("not authenticate");
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
			log.info("authenticate " + authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(email, password)).getName());
		} catch (BadCredentialsException e) {
			// TODO: handle exception
			throw new Exception("verifier votre mot de pass");
		}
		UserDetails user = (UserDetails) userdetailsimpl.loadUserByUsername(email);
		return utoken.generateToken(user);

	}

}
