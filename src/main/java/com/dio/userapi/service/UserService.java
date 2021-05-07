package com.dio.userapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.userapi.dto.request.UserDTO;
import com.dio.userapi.dto.response.MessageResponseDTO;
import com.dio.userapi.entity.User;
import com.dio.userapi.mapper.UserMapper;
import com.dio.userapi.repository.UserRepository;
import com.dio.userapi.service.exception.UserNotFoundException;

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

	public List<UserDTO> listAll() {
		
		List<User> allUser = userRepository.findAll();
		return allUser.stream()
				.map(userMapper::toDTO)
				.collect(Collectors.toList());
	}

	public UserDTO findById(Long id) throws UserNotFoundException {
		
		User user = verifyIfExists(id);
		
		return userMapper.toDTO(user);
	}

	public void delete(Long id) throws UserNotFoundException {
		
		verifyIfExists(id);
		
		userRepository.deleteById(id);
	}

	private User verifyIfExists(Long id) throws UserNotFoundException {
		return userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException(id));
	}
}
