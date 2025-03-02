package com.game.globetrotter.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "clues")
public class Clue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_id", nullable = false)
    private Destination destination;

    @Column(nullable = false, length = 500)
    private String text;
}