package com.game.globetrotter.controller;

import com.game.globetrotter.dto.AnswerResponseDTO;
import com.game.globetrotter.dto.GameQuestionDTO;
import com.game.globetrotter.dto.ResponseDTO;
import com.game.globetrotter.service.DestinationService;
import com.game.globetrotter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game")
@RequiredArgsConstructor
public class GameController {

    private final DestinationService destinationService;
    private final UserService userService;

    @GetMapping("/question")
    public ResponseEntity<GameQuestionDTO> getRandomQuestion() {
        return ResponseEntity.ok(destinationService.getRandomQuestion());
    }

    @PostMapping("/answer")
    public ResponseEntity<AnswerResponseDTO> submitAnswer(@RequestBody ResponseDTO answer) {

        boolean isCorrect = destinationService.checkAnswer(answer);

        // Update user's score
        userService.updateScore(answer.getUsername(), isCorrect);

        // Get user's updated score
        int totalScore = userService.getUserScore(answer.getUsername()).getTotalScore();

        // Get a random fact based on answer correctness
        String fact = destinationService.getRandomFact(answer.getDestinationId(), isCorrect);

        return ResponseEntity.ok(AnswerResponseDTO.builder()
                .correct(isCorrect)
                .fact(fact)
                .totalScore(totalScore)
                .build());
    }
}