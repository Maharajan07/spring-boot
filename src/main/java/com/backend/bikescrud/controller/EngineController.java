package com.backend.bikescrud.controller;

import com.backend.bikescrud.dto.BikeDTO;
import com.backend.bikescrud.dto.EngineDTO;
import com.backend.bikescrud.entity.Engine;
import com.backend.bikescrud.service.EngineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/engine")
public class EngineController {

    private final EngineService engineService;

    public EngineController(EngineService engineService) {
        this.engineService = engineService;
    }

    @GetMapping("/{id}")
    public String getCc(@PathVariable Long id) {
        return engineService.getCc(id);
    }

    @GetMapping
    public List<Engine> getEngine() {
        return engineService.getEngine();
    }

    @PostMapping
    public String saveEngine(@RequestBody EngineDTO engineDTO) {
        return engineService.createEngine(engineDTO);
    }

    @PutMapping("/{id}")
    public String updateEngine(@RequestBody EngineDTO engineDTO, @PathVariable Long id) {
        return engineService.updateEngine(engineDTO, id);
    }

    @PatchMapping("/{id}")
    public String patchEngine(@RequestParam Integer cc, @PathVariable Long id) {
        return engineService.patchEngine(cc, id);
    }

    @DeleteMapping("/{id}")
    public String deleteEngine(@PathVariable Long id) {
        return engineService.deleteEngine(id);
    }

}
