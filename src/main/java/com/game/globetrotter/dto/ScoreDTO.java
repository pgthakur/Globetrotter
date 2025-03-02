package com.game.globetrotter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScoreDTO {
    private String username;
    private Integer correctAnswers;
    private Integer wrongAnswers;
    private Integer totalScore;
}