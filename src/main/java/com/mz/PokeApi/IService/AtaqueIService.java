package com.mz.PokeApi.IService;
import java.util.List; 
import com.mz.PokeApi.entidades.Ataque;
 
public interface AtaqueIService { 
public List<Ataque> findAllAtaques(); 
public Ataque saveAtaque(Ataque ataque); 
} 
