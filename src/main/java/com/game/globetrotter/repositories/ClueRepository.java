package com.game.globetrotter.repositories;

import com.game.globetrotter.entities.Clue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClueRepository extends JpaRepository<Clue, Long> {
    List<Clue> findByDestinationId(Long destinationId);

    @Query(value = "SELECT * FROM clues WHERE destination_id = :destinationId ORDER BY RAND() LIMIT :limit", nativeQuery = true)
    List<Clue> findRandomCluesByDestinationId(@Param("destinationId") Long destinationId, @Param("limit") int limit);
}