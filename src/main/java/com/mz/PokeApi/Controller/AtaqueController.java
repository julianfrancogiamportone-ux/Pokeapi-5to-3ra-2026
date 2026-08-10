package com.mz.PokeApi.Controller;

import java.util.List; 
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController; 
import com.mz.PokeApi.IService.AtaqueIService; 
import com.mz.PokeApi.entidades.Ataque;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@RestController 
@RequestMapping("/api/Ataque") 
public class AtaqueController { 
 
    @Autowired 
    private AtaqueIService aService; 
 
    @GetMapping 
    public List<Ataque> getAllAtaques() { 
        return aService.findAllAtaques(); 
    } 
 
    @PostMapping 
    public Ataque createAtaque(@RequestBody Ataque ataque) { 
        return aService.saveAtaque(ataque); 
    } 
}

