package com.game.globetrotter.service;

import com.game.globetrotter.dto.ScoreDTO;
import com.game.globetrotter.dto.UserDTO;
import com.game.globetrotter.exception.ResourceAlreadyExistsException;
import com.game.globetrotter.exception.ResourceNotFoundException;
import com.game.globetrotter.entities.User;
import com.game.globetrotter.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserDTO createUser(String username) {
        if (userRepository.existsByUsername(username)) {
            throw new ResourceAlreadyExistsException("Username already exists: " + username);
        }

        User user = new User();
        user.setUsername(username);
        user = userRepository.save(user);

        return mapToDTO(user);
    }

    @Transactional(readOnly = true)
    public UserDTO getUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + username));

        return mapToDTO(user);
    }

    @Transactional
    public void updateScore(String username, boolean isCorrect) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + username));

        if (isCorrect) {
            user.setCorrectAnswers(user.getCorrectAnswers() + 1);
        } else {
            user.setWrongAnswers(user.getWrongAnswers() + 1);
        }

        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public ScoreDTO getUserScore(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + username));

        return ScoreDTO.builder()
                .username(user.getUsername())
                .correctAnswers(user.getCorrectAnswers())
                .wrongAnswers(user.getWrongAnswers())
                .totalScore(user.getCorrectAnswers() - user.getWrongAnswers())
                .build();
    }

    private UserDTO mapToDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .correctAnswers(user.getCorrectAnswers())
                .wrongAnswers(user.getWrongAnswers())
                .build();
    }
}