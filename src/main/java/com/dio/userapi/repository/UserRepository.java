package com.dio.userapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dio.userapi.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
