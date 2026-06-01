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

@RestController
@RequestMapping("/api/characters")

public class ArmaController {
    @Autowired
    private ArmaIService aService;

    @GetMapping
    public List<Arma> getAllCharacters() {
        return aService.findAllCharacters();
    }

    @PostMapping
    public Arma createCharacter(@RequestBody Arma arma) {
        return aService.saveCharacter(arma);
    }
}
