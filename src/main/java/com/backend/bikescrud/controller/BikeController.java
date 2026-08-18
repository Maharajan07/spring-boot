package com.backend.bikescrud.controller;

import com.backend.bikescrud.dto.BikeDTO;
import com.backend.bikescrud.service.BikeService;
import com.backend.bikescrud.entity.Bikes;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BikeController {

    private final BikeService bikeService;

    public BikeController(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    @GetMapping("/api/bikes/{id}")
    public String getBike(@PathVariable Long id) {
        return bikeService.getBikeName(id);
    }

    @GetMapping("/api/bikes")
    public List<Bikes> getAllBikes() {
        return bikeService.getAllBikes();
    }

    @PostMapping("/api/bikes")
    public String saveBike(@RequestBody BikeDTO bikeDTO) {
        return bikeService.createBike(bikeDTO);
    }

    @PutMapping("/api/bikes/{id}")
    public String updateBike(@RequestBody BikeDTO bikeDTO, @PathVariable Long id) {
        return bikeService.updateBike(bikeDTO, id);
    }

    @PatchMapping("/api/bikes/{id}")
    public String patchBike(@RequestParam String BikeName, @PathVariable Long id) {
        return bikeService.patchBike(BikeName, id);
    }

    @DeleteMapping("/api/bikes/{id}")
    public void deleteBike(@PathVariable Long id) {
        bikeService.deleteBike(id);
    }
}
