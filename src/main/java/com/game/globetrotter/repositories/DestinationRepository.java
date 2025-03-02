package com.game.globetrotter.repositories;

import com.game.globetrotter.entities.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {
    Optional<Destination> findByCityAndCountry(String city, String country);

    @Query(value = "SELECT * FROM destinations ORDER BY RAND() LIMIT 3", nativeQuery = true)
    List<Destination> findRandomDestination();

    @Query(value = "SELECT * FROM destinations WHERE id != :id ORDER BY RAND() LIMIT :limit", nativeQuery = true)
    List<Destination> findRandomDestinationsExcept(@Param("id") Long id, @Param("limit") int limit);

    @Query(value = "SELECT * FROM destinations WHERE id NOT IN :ids ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Destination> findRandomDestinationExcept(@Param("ids") List<Long> ids);
    @Query(value = "SELECT * FROM destinations WHERE id = :id", nativeQuery = true)
    List<Destination> findAllDestinationById(@Param("id") Long id);
}