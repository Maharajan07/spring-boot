package com.backend.bikescrud.service;

import com.backend.bikescrud.dto.EngineDTO;
import com.backend.bikescrud.entity.Engine;
import com.backend.bikescrud.repository.EngineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EngineService {

    private final EngineRepository engineRepository;

    public EngineService(EngineRepository engineRepository) {
        this.engineRepository = engineRepository;
    }

    public String getCc(Long id) {
        Engine engine = engineRepository.findById(id).orElseThrow();
        return "Engine CC: " + engine.getCc();
    }

    public List<Engine> getEngine() {
        return engineRepository.findAll();
    }

    public String createEngine(EngineDTO engineDTO) {
        Engine engine = new Engine();
        engine.setCc(engineDTO.getCc());
        engine.setBhp(engineDTO.getBhp());
        engine.setNm(engineDTO.getNm());
        engineRepository.save(engine);
        return "Engine created successfully";
    }

    public String updateEngine(EngineDTO engineDTO, Long id) {
        Engine engine = engineRepository.findById(id).orElseThrow();
        engine.setNm(engineDTO.getNm());
        engineRepository.save(engine);
        return "Engine updated successfully";
    }

    public String patchEngine(Integer cc, Long id) {
        Engine engine = engineRepository.findById(id).orElseThrow();
        engine.setCc(cc);
        engineRepository.save(engine);
        return "Engine patched successfully";
    }

    public String deleteEngine(Long id) {
        engineRepository.deleteById(id);
        return "Engine deleted successfully";
    }
}
