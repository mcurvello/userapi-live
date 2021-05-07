package com.dio.userapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dio.userapi.dto.request.UserDTO;
import com.dio.userapi.dto.response.MessageResponseDTO;
import com.dio.userapi.service.UserService;
import com.dio.userapi.service.exception.UserNotFoundException;

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
	
	@GetMapping
	public List<UserDTO> listAll() {
		return userService.listAll();
	}
	
	@GetMapping("/{id}")
	public UserDTO findById(@PathVariable Long id) throws UserNotFoundException {
		return userService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws UserNotFoundException{
		userService.delete(id);
	}
}
