package com.backend.bikescrud.service;

import com.backend.bikescrud.dto.BikeDTO;
import com.backend.bikescrud.entity.Bikes;
import com.backend.bikescrud.repository.BikeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeService {

    private final BikeRepository bikeRepository;

    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    public String getBikeName(Long id) {
        Bikes bike = bikeRepository.findById(id).orElseThrow();
        return "bike: " + bike.getBikeName();
    }

    public List<Bikes> getAllBikes() {
        return bikeRepository.findAll();
    }

    public String createBike(BikeDTO bikeDTO) {
        Bikes bike = new Bikes();
        bike.setBikeName(bikeDTO.getBikeName());
        bike.setPrice(bikeDTO.getPrice());
        bikeRepository.save(bike);
        return "Bike saved successfully!";
    }

    public String updateBike(BikeDTO bikeDTO, Long id) {
        Bikes bike = bikeRepository.findById(id).orElseThrow();
        bike.setBikeName(bikeDTO.getBikeName());
        bike.setPrice(bikeDTO.getPrice());
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
        bikeRepository.deleteById(id);
    }
}
