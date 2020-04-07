package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepository;

@Controller
public class UserRegistrationController {

	@Autowired
	AccountRepository accRepo;

	//初期表示用
	@RequestMapping(path = "/user-registration", method = RequestMethod.GET)
	public String fwdUserResistration() {

		return "/user-registration";
	}

	//登録用
	@RequestMapping(path = "/user-registration", method = RequestMethod.POST)
	public String userResist(Model model, Account account) {

		//encode password
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		account.setPassword(encoder.encode(account.getPassword()));

		//insert
		accRepo.save(account);
		return "redirect:/user-registration";
	}

}