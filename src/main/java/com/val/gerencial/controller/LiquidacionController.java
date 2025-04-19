package com.val.gerencial.controller;


import com.val.gerencial.model.Liquidacion;

import com.val.gerencial.service.LiquidacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/liquidaciones")
@CrossOrigin(origins = "http://localhost:4200") // o el frontend real
public class LiquidacionController {

    @Autowired
    private LiquidacionService liquidacionService;

    @GetMapping("/persona/{id}")
    public List<Liquidacion> obtenerLiquidacionesPorPersona(@PathVariable("id") Long id) {
        return liquidacionService.findByPersonaId(id);
    }
}