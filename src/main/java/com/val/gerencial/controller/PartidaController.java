package com.val.gerencial.controller;

import com.val.gerencial.model.Imputacion;
import com.val.gerencial.model.Partida;
import com.val.gerencial.repository.ImputacionRepository;
import com.val.gerencial.repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/partidas")
@CrossOrigin(origins = "http://localhost:4200") // o el frontend real
public class PartidaController {

    @Autowired
    private PartidaRepository partidaRepository;

    @Autowired
    private ImputacionRepository imputacionRepository;

    @GetMapping
    public List<Partida> getAllPartidas() {
        return partidaRepository.findAll();
    }

    @GetMapping("/periodos/{id}")
    public List<Map<String, Object>> getPeriodosPorPartida(@PathVariable Long id) {
        List<Imputacion> imputaciones = imputacionRepository.findByPartidaId(id);

        return imputaciones.stream()
                .collect(Collectors.groupingBy(
                        imp -> Map.of("ano", imp.getLiquidacion().getAnoLiqui(), "mes", imp.getLiquidacion().getMesLiqui()),
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .map(entry -> {
                    Map<String, Object> periodData = new HashMap<>(entry.getKey());
                    periodData.put("cantidad", entry.getValue());
                    return periodData;
                })
                .sorted(Comparator.comparingInt(m -> ((Integer) m.get("ano")) * 100 + (Integer) m.get("mes")))
                .toList();
    }
}
