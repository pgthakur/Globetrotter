package com.game.globetrotter.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "fun_facts")
public class Funfact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_id", nullable = false)
    private Destination destination;

    @Column(nullable = false, length = 500)
    private String text;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FactType type;

    public enum FactType {
        FUN_FACT,
        TRIVIA
    }
}