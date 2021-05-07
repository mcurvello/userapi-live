package com.dio.userapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.userapi.dto.request.UserDTO;
import com.dio.userapi.dto.response.MessageResponseDTO;
import com.dio.userapi.entity.User;
import com.dio.userapi.mapper.UserMapper;
import com.dio.userapi.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;
	
	private final UserMapper userMapper = UserMapper.INSTANCE;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public MessageResponseDTO createUser(UserDTO userDTO) {
		
		User userToSave = userMapper.toModel(userDTO);
		
		User savedUser = userRepository.save(userToSave);
		return MessageResponseDTO
				.builder()
				.message("Created user wit ID * " + savedUser.getId())
				.build();
	}
}
