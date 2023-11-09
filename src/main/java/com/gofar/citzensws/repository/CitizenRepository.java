package com.gofar.citzensws.repository;

import com.gofar.citzensws.entity.Citizen;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {

    @EntityGraph(attributePaths = {"mother", "father", "job"})
    Optional<Citizen> findByCin(String cin);
}
