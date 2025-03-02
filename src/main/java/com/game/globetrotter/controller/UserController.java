package com.game.globetrotter.controller;

import com.game.globetrotter.dto.ScoreDTO;
import com.game.globetrotter.dto.UserDTO;
import com.game.globetrotter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestParam String username) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(username));
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }

    @GetMapping("/{username}/score")
    public ResponseEntity<ScoreDTO> getUserScore(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUserScore(username));
    }
}