package com.game.globetrotter.service;

import com.game.globetrotter.dto.ChallangeDTO;
import com.game.globetrotter.exception.ResourceNotFoundException;
import com.game.globetrotter.entities.Challange;
import com.game.globetrotter.entities.User;
import com.game.globetrotter.repositories.ChallangeRepository;
import com.game.globetrotter.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChallangeService {

    private final ChallangeRepository challengeRepository;
    private final UserRepository userRepository;

    @Transactional
    public ChallangeDTO createChallenge(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + username));

        Challange challenge = new Challange();
        challenge.setChallengeId(UUID.randomUUID().toString());
        challenge.setCreator(user);
        challenge = challengeRepository.save(challenge);

        return ChallangeDTO.builder()
                .challengeId(challenge.getChallengeId())
                .creatorUsername(user.getUsername())
                .inviteLink("/challenge/" + challenge.getChallengeId())
                .creatorScore(user.getCorrectAnswers() - user.getWrongAnswers())
                .build();
    }

    @Transactional(readOnly = true)
    public ChallangeDTO getChallengeDetails(String challengeId) {
        Challange challenge = challengeRepository.findByChallengeId(challengeId)
                .orElseThrow(() -> new ResourceNotFoundException("Challenge not found: " + challengeId));

        User creator = challenge.getCreator();

        return ChallangeDTO.builder()
                .challengeId(challenge.getChallengeId())
                .creatorUsername(creator.getUsername())
                .inviteLink("/challenge/" + challenge.getChallengeId())
                .creatorScore(creator.getCorrectAnswers() - creator.getWrongAnswers())
                .build();
    }
}