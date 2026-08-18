package com.backend.bikescrud.service;

import com.backend.bikescrud.dto.BikeDTO;
import com.backend.bikescrud.dto.BikeReqDTO;
import com.backend.bikescrud.entity.Bikes;
import com.backend.bikescrud.entity.Engine;
import com.backend.bikescrud.repository.BikeRepository;
import com.backend.bikescrud.repository.EngineRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeService {

    private final BikeRepository bikeRepository;
    private final EngineRepository engineRepository;

    public BikeService(BikeRepository bikeRepository, EngineRepository engineRepository) {
        this.bikeRepository = bikeRepository;
        this.engineRepository = engineRepository;
    }

    public String getBikeName(Long id) {
        Bikes bike = bikeRepository.findById(id).orElseThrow();
        return "bike: " + bike.getBikeName();
    }

    public List<Bikes> getAllBikes() {
        return bikeRepository.findAll();
    }

    public Bikes createBike(BikeReqDTO reqDTO) {

        Engine foundEngine = engineRepository.findById(reqDTO.getEngineId()).orElseThrow();
        Bikes bike = new Bikes();

        bike.setBikeName(reqDTO.getBikeName());
        bike.setPrice(reqDTO.getPrice());
        bike.setEngine(foundEngine);

        return bikeRepository.save(bike);
    }

    public String updateBike(BikeReqDTO reqDTO, Long id) {
        Engine foundEngine = engineRepository.findById(reqDTO.getEngineId()).orElseThrow();
        Bikes bike = bikeRepository.findById(id).orElseThrow();
        bike.setBikeName(reqDTO.getBikeName());
        bike.setPrice(reqDTO.getPrice());
        bike.setEngine(foundEngine);
        bikeRepository.save(bike);
        return "Bike updated successfully!";
    }

    public String patchBike(String BikeName, Long id) {
        Bikes bike = bikeRepository.findById(id).orElseThrow();
        bike.setBikeName(BikeName);
        bikeRepository.save(bike);
        return "BikeName patched successfully!";
    }

    public void deleteBike(Long id) {
        Bikes existingBike = bikeRepository.findById(id).orElseThrow();
        bikeRepository.delete(existingBike);
    }

}
