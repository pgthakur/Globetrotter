package com.game.globetrotter.repositories;

import com.game.globetrotter.entities.Challange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChallangeRepository extends JpaRepository<Challange, Long> {
    Optional<Challange> findByChallengeId(String challengeId);
}