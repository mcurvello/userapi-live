package com.dio.userapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dio.userapi.dto.request.UserDTO;
import com.dio.userapi.dto.response.MessageResponseDTO;
import com.dio.userapi.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	private UserService userService;
	
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO createUser(@RequestBody @Valid UserDTO userDTO) {
		return userService.createUser(userDTO);
	}
}
