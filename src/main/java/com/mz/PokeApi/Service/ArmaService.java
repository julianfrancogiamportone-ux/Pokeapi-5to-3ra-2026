package com.mz.PokeApi.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mz.PokeApi.IService.ArmaIService;
import com.mz.PokeApi.entidades.Arma;
import com.mz.PokeApi.Repository.ArmaRepository;

public class ArmaService implements ArmaIService{
    @Autowired
    private ArmaRepository aRepository;
    public List<Arma> findAllArmas() {
        return aRepository.findAll();
    }
    public Arma saveArma(Arma arma) {
        return aRepository.save(arma);
}
}
