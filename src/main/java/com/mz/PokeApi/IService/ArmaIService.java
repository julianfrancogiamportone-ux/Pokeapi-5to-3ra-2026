package com.mz.PokeApi.IService;
import java.util.List;
import com.mz.PokeApi.entidades.Arma;


public interface ArmaIService {
    public List<Arma> findAllCharacters();
    public Arma saveCharacter(Arma arma);
}
