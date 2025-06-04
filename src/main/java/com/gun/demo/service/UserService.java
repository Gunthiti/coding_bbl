package com.gun.demo.service;

import com.gun.demo.dto.UserDto;
import com.gun.demo.entity.User;
import com.gun.demo.mapper.UserMapper;
import com.gun.demo.model.CreateUserRequest;
import com.gun.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDto> getAllUser() {
        return userRepository.findAll().stream().map(userMapper::toDto).toList();
    }

    public UserDto getUserById(Long userId) {
        return userRepository.findById(userId)
                .map(userMapper::toDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found"));
    }

    public UserDto createUser(CreateUserRequest createUserRequest) {
        return userMapper.toEntity(userRepository.save(createUserRequest));
    }
}
