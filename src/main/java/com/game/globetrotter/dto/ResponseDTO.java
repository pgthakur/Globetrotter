package com.game.globetrotter.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class ResponseDTO {
    private Long destinationId;
    private String city;
    private String country;
    private String username;
}
