package com.game.globetrotter.service;

import com.game.globetrotter.dto.DestinationDTO;
import com.game.globetrotter.dto.GameQuestionDTO;
import com.game.globetrotter.dto.ResponseDTO;
import com.game.globetrotter.entities.Clue;
import com.game.globetrotter.entities.Destination;
import com.game.globetrotter.entities.Funfact;
import com.game.globetrotter.repositories.ClueRepository;
import com.game.globetrotter.repositories.DestinationRepository;
import com.game.globetrotter.repositories.FunfactRepository;
import com.game.globetrotter.util.ConvertToDestinationDTOs;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DestinationService {

    private final DestinationRepository destinationRepository;
    private final ClueRepository clueRepository;
    private final FunfactRepository funFactRepository;

    @Transactional(readOnly = true)
    public GameQuestionDTO getRandomQuestion() {
        // Get a random destination
        List<Destination> destination = destinationRepository.findRandomDestination();

        //convert to dtos
        List<DestinationDTO> destinationDTOS = ConvertToDestinationDTOs.getDestinationDTOs(destination);
        // Get 2 random clues for this destination
        List<Clue> clues = clueRepository.findRandomCluesByDestinationId(destination.get(0).getId(), 2);
        Long id = destination.get(0).getId();
        List<String> cluesText = new ArrayList<>();
        for(var a:clues)
        {
            cluesText.add(a.getText());
        }

        return GameQuestionDTO.builder()
                .destination(destinationDTOS)
                .clues(cluesText)
                .id(id)
                .build();
    }

    @Transactional(readOnly = true)
    public String getRandomFact(Long destinationId, boolean isCorrectAnswer) {
        Funfact.FactType factType = isCorrectAnswer ? Funfact.FactType.FUN_FACT : Funfact.FactType.TRIVIA;
        return funFactRepository.findRandomFactByDestinationIdAndType(destinationId, factType.name())
                .map(Funfact::getText)
                .orElse("No fact available for this destination.");
    }

    public boolean checkAnswer(ResponseDTO answer)
    {
        List<Destination> destinations = destinationRepository.findAllDestinationById(answer.getDestinationId());
        for(var dest: destinations)
        {
            if(answer.getCity().equals(dest.getCity()) && answer.getCountry().equals(dest.getCountry()))
            {
                return true;
            }
        }
        return false;
    }

    @Transactional
    public void seedDestinationData(List<DestinationDTO> destinations) {
        for (DestinationDTO dto : destinations) {
            Optional<Destination> existingDestination = destinationRepository.findByCityAndCountry(
                    dto.getCity(), dto.getCountry());

            if (existingDestination.isPresent()) {
                continue; // Skip if already exists
            }

            // Create new destination
            Destination destination = new Destination();
            destination.setCity(dto.getCity());
            destination.setCountry(dto.getCountry());
            destination = destinationRepository.save(destination);

            // Add clues
            for (String clueText : dto.getClues()) {
                Clue clue = new Clue();
                clue.setDestination(destination);
                clue.setText(clueText);
                clueRepository.save(clue);
            }

            // Add fun facts
            for (String factText : dto.getFunFact()) {
                Funfact funFact = new Funfact();
                funFact.setDestination(destination);
                funFact.setText(factText);
                funFact.setType(Funfact.FactType.FUN_FACT);
                funFactRepository.save(funFact);
            }

            // Add trivia
            for (String triviaText : dto.getTrivia()) {
                Funfact trivia = new Funfact();
                trivia.setDestination(destination);
                trivia.setText(triviaText);
                trivia.setType(Funfact.FactType.TRIVIA);
                funFactRepository.save(trivia);
            }
        }
    }
}