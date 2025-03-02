package com.game.globetrotter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DestinationDTO {
    private String city;
    private String country;
    private List<String> clues;

    @JsonProperty("fun_fact")
    private List<String> funFact;

    private List<String> trivia;
}