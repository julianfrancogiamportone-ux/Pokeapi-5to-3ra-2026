package com.mz.PokeApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mz.PokeApi.IService.ArmaIService;
import com.mz.PokeApi.entidades.Arma;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/arma")

public class ArmaController {
    @Autowired
    private ArmaIService aService;

    @GetMapping
    public List<Arma> getAllArmas() {
        return aService.findAllArmas();
    }

    @PostMapping
    public Arma createArma(@RequestBody Arma arma) {
        return aService.saveArma(arma);
    }
}
