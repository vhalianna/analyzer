package com.val.gerencial.controller;

import com.val.gerencial.model.Cargo;
import com.val.gerencial.repository.CargoRepository;
import com.val.gerencial.service.CargoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cargos")
@CrossOrigin(origins = "http://localhost:4200") // o el frontend real
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @GetMapping("/persona/{id}")
    public List<Cargo> obtenerCargosPorPersona(@PathVariable("id") Long id) {
        return cargoService.findByPersonaId(id);
    }
}