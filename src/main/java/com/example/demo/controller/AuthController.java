package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.repository.AccountRepository;

@Controller
public class AuthController {

	@RequestMapping("/")
	public String index() {
		return "redirect:/top";
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@Autowired
	AccountRepository accRepo;

	@RequestMapping(value = "/top", method = RequestMethod.GET)
	public void getLoginUser(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("loginUser", accRepo.findByUsername(auth.getName()));
	}

}