package com.example.demo.userService;

import org.springframework.stereotype.Service;

import com.example.demo.DAO.user;

public interface userService {
	public user ajouterUser(user u);
	public void deleteUser(Long u);
	public user modifierUSer(user u);
	public user getUser(Long id);
	public user findUserByemail(String email);
	public boolean excituser(String mail);
}
