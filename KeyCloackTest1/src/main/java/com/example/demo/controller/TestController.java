package com.example.demo.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("auth")
public class TestController {

	@GetMapping(path = "/")
	public String index() {
		return "external";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) throws Exception {
		request.logout();
		return "redirect:/";
	}

	@GetMapping(path = "/testData")
	public List<String> customers(Principal principal) {

		List<String> testdata = new ArrayList<>();
		testdata.add("jack");
		testdata.add("don");
		testdata.add("jhon");

		return testdata;
	}

	@GetMapping("/status")
	public ResponseEntity<?> test1() {

		return new ResponseEntity<>("hi everyone", HttpStatus.OK);
	}
}
