package com.example.demo.userService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.user;
@Service
public class userServiceImpl implements userService {
	@Autowired
	private userRepository ur;

	@Override
	public user ajouterUser(user u) {
		// TODO Auto-generated method stub
		return ur.save(u);
	}

	@Override
	public void deleteUser(Long u) {
		// TODO Auto-generated method stub
		ur.deleteById(u);
	}

	@Override
	public user modifierUSer(user u) {
		// TODO Auto-generated method stub
		return ur.save(u);
	}

	@Override
	public user getUser(Long id) {
		// TODO Auto-generated method stub
		return ur.findById(id).get();
	}

	@Override
	public boolean excituser(String mail) {
		if(Optional.of(ur.findByMail(mail)).isPresent())
			 return true;
		return false;
	}

	@Override
	public user findUserByemail(String email) {
		// TODO Auto-generated method stub
		return ur.findByMail(email);
	}

}
