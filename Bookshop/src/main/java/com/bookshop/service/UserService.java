package com.bookshop.service;

import com.bookshop.model.UserEntity;
import com.bookshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public Optional<UserEntity> getUserById(Integer id) {
		return userRepository.findById(id);
	}

	public UserEntity createNewUser(UserEntity user) {
		return userRepository.save(user);
	}

	public UserEntity editUserProfile(UserEntity user, Integer userId) {
		userRepository.deleteById(userId);
		return userRepository.save(user);
	}

	public void deleteUser(Integer userId) {
		userRepository.deleteById(userId);
	}
}
