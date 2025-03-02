package com.game.globetrotter.controller;

import com.game.globetrotter.dto.DestinationDTO;
import com.game.globetrotter.service.DestinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class DataSeedController {

    private final DestinationService destinationService;

    @PostMapping("/seed")
    public ResponseEntity<String> seedData(@RequestBody List<DestinationDTO> destinations) {
        destinationService.seedDestinationData(destinations);
        return ResponseEntity.ok("Data seeded successfully");
    }
}