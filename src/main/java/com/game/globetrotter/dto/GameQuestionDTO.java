package com.game.globetrotter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameQuestionDTO {
    private List<DestinationDTO> destination;
    private List<String> clues;
    private Long id;
}