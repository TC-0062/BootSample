package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.AccountRepository;

@Controller
public class UserlistController {

	@Autowired
	AccountRepository accRepo;

	@RequestMapping("/userlist")
	public String userlist(Model model) {
		model.addAttribute("users", accRepo.findAll());
		return "/userlist";
	}

}