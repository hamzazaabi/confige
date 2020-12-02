package com.example.demo.userService;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.DAO.user;

public interface userRepository extends JpaRepository<user, Long> {
	public  user findByMail(String mail);
	public user findByNom(String a);
	public user findByPassWord(String a);
   
}