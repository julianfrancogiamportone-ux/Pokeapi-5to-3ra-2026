package com.mz.PokeApi.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mz.PokeApi.IService.PeleadorIService;
import com.mz.PokeApi.entidades.Peleador;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/characters")

public class PeleadorController {
    @Autowired
    private PeleadorIService aService;

    @GetMapping
    public List<Peleador> getAllCharacters() {
        return aService.findAllCharacters();
    }

    @PostMapping
    public Peleador createCharacter(@RequestBody Peleador peleador) {
        return aService.saveCharacter(peleador);
    }
}