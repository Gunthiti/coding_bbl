package com.gun.demo.controller;

import com.gun.demo.dto.UserDto;
import com.gun.demo.model.ApiResponse;
import com.gun.demo.model.CreateUserRequest;
import com.gun.demo.model.EditUserRequest;
import com.gun.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<ApiResponse<List<UserDto>>> getAllUser () {
        return ResponseEntity.ok(ApiResponse.success(userService.getAllUser()));
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<ApiResponse<UserDto>> getUserById(
            @PathVariable String userId
    ) {
        return ResponseEntity.ok(ApiResponse.success(userService.getUserById(Long.parseLong(userId))));
    }

    @PostMapping("/users")
    public ResponseEntity<ApiResponse<UserDto>> createUser(
            @RequestBody CreateUserRequest createUserRequest
            ){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(createUserRequest));
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<ApiResponse<UserDto>> updateUserById( @RequestBody EditUserRequest editUserRequest, @PathVariable String userId) {
       return ResponseEntity.ok(userService.updateUserById(editUserRequest, userId));
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> deleteUserById (
            @PathVariable String userId
    ) {
        return ResponseEntity.noContent().build(userService.deleteUserById(userId));
    }
}
