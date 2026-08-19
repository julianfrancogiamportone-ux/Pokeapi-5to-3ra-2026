package com.mz.PokeApi.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mz.PokeApi.IService.PeleadorIService;
import com.mz.PokeApi.entidades.Peleador;
import com.mz.PokeApi.Repository.PeleadorRepository;

@Service
public class PeleadorService implements PeleadorIService {
    @Autowired
    private PeleadorRepository pRepository;

    public List<Peleador> findAllCharacters() {
        return pRepository.findAll();
    }

    public Peleador saveCharacter(Peleador peleador) {
        return pRepository.save(peleador);
    }
}
