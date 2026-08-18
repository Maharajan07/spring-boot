package com.backend.bikescrud.controller;

import com.backend.bikescrud.dto.BikeDTO;
import com.backend.bikescrud.dto.BikeReqDTO;
import com.backend.bikescrud.service.BikeService;
import com.backend.bikescrud.entity.Bikes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bikes")
public class BikeController {

    private final BikeService bikeService;

    public BikeController(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    @GetMapping("/{id}")
    public String getBike(@PathVariable Long id) {
        return bikeService.getBikeName(id);
    }

    @GetMapping
    public List<Bikes> getAllBikes() {
        return bikeService.getAllBikes();
    }

    @PostMapping
    public ResponseEntity<Bikes> addBike(@RequestBody BikeReqDTO reqDTO) {
        Bikes savedBike = bikeService.createBike(reqDTO);

        return new ResponseEntity<>(savedBike, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public String updateBike(@RequestBody BikeReqDTO reqDTO, @PathVariable Long id) {
        return bikeService.updateBike(reqDTO, id);
    }

    @PatchMapping("/{id}")
    public String patchBike(@RequestParam String BikeName, @PathVariable Long id) {
        return bikeService.patchBike(BikeName, id);
    }

    @DeleteMapping("/{id}")
    public void deleteBike(@PathVariable Long id) {
        bikeService.deleteBike(id);
    }
}
