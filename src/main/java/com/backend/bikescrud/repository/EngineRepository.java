package com.backend.bikescrud.repository;

import com.backend.bikescrud.entity.Engine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EngineRepository extends JpaRepository<Engine, Long> {
}
