package com.game.globetrotter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChallangeDTO {
    private String challengeId;
    private String creatorUsername;
    private String inviteLink;
    private Integer creatorScore;
}