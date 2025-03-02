package com.game.globetrotter.repositories;

import com.game.globetrotter.entities.Funfact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FunfactRepository extends JpaRepository<Funfact, Long> {
    List<Funfact> findByDestinationIdAndType(Long destinationId, Funfact.FactType type);

    @Query(value = "SELECT * FROM fun_facts WHERE destination_id = :destinationId AND type = :type ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Funfact> findRandomFactByDestinationIdAndType(@Param("destinationId") Long destinationId, @Param("type") String type);
}