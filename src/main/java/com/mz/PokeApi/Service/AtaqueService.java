package com.mz.PokeApi.Service;
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import com.mz.PokeApi.IService.AtaqueIService; 
import com.mz.PokeApi.entidades.Ataque; 
import com.mz.PokeApi.Repository.AtaqueRepository; 

@Service
public class AtaqueService implements AtaqueIService { 
    @Autowired 
    private AtaqueRepository pRepository; 

    public List<Ataque> findAllAtaques() { 
        return pRepository.findAll(); 
    } 
    
    public Ataque saveAtaque(Ataque ataque) { 
        return pRepository.save(ataque); 
    } 
} 

