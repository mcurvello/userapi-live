package com.dio.userapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.userapi.dto.response.MessageResponseDTO;
import com.dio.userapi.entity.User;
import com.dio.userapi.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public MessageResponseDTO createUser(User user) {
		User savedUser = userRepository.save(user);
		return MessageResponseDTO
				.builder()
				.message("Created user wit ID * " + savedUser.getId())
				.build();
	}
}
