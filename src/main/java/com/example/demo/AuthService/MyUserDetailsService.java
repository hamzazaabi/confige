package com.example.demo.AuthService;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.user;
import com.example.demo.userService.userRepository;
import com.example.demo.userService.userService;

@Service
public class MyUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
	@Autowired
	private userService us;
	@Autowired
	private userRepository ur;

	@Override
	public UserDetails loadUserByUsername(String username)  {
		
		Optional<user> user = Optional.of(us.findUserByemail(username));
		
		if(user.isPresent()==false) {
			throw new UsernameNotFoundException("email"+username+" nexcite pas ");
		}
		
		return new User(user.get().getMail(), user.get().getPassWord(), new ArrayList<>());
	}

}
