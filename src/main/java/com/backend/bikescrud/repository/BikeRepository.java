package com.backend.bikescrud.repository;

import com.backend.bikescrud.entity.Bikes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepository extends JpaRepository<Bikes, Long> {
}
