package com.dio.userapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.dio.userapi.dto.request.UserDTO;
import com.dio.userapi.entity.User;

@Mapper
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	@Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
	User toModel(UserDTO userDTO);
	
	UserDTO toDTO(User user);
}
