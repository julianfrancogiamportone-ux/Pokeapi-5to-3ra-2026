package com.mz.PokeApi.IService;

import java.util.List;
import com.mz.PokeApi.entidades.Peleador;

public interface PeleadorIService {
    public List<Peleador> findAllCharacters();

    public Peleador saveCharacter(Peleador peleador);
}