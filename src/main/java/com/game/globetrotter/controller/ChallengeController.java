package com.game.globetrotter.controller;

import com.game.globetrotter.dto.ChallangeDTO;
import com.game.globetrotter.service.ChallangeService;
import com.game.globetrotter.util.ImageGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/challenges")
@RequiredArgsConstructor
public class ChallengeController {

    private final ChallangeService challengeService;
    private final ImageGenerator imageGenerator;

    @PostMapping
    public ResponseEntity<ChallangeDTO> createChallenge(@RequestParam String username) {
        return ResponseEntity.ok(challengeService.createChallenge(username));
    }

    @GetMapping("/{challengeId}")
    public ResponseEntity<ChallangeDTO> getChallengeDetails(@PathVariable String challengeId) {
        return ResponseEntity.ok(challengeService.getChallengeDetails(challengeId));
    }

    @GetMapping(value = "/{challengeId}/image", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getChallengeImage(@PathVariable String challengeId) {
        ChallangeDTO challenge = challengeService.getChallengeDetails(challengeId);
        byte[] imageBytes = imageGenerator.generateChallengeImage(challenge);
        return ResponseEntity.ok().contentType(MediaType.valueOf(MediaType.IMAGE_PNG_VALUE)).body(imageBytes);
    }
}