package com.mz.PokeApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mz.PokeApi.entidades.Peleador;

public interface PeleadorRepository extends JpaRepository<Peleador, Long> {
}