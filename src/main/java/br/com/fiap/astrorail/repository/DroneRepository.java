package br.com.fiap.astrorail.repository;

import br.com.fiap.astrorail.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneRepository
        extends JpaRepository<Drone, Long> {
}