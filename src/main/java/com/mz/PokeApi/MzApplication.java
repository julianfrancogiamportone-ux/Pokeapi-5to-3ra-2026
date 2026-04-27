
package com.mz.PokeApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mz.PokeApi.entidades.Ataque;

@SpringBootApplication
public class MzApplication {

	public static void main(String[] args) {
		SpringApplication.run(MzApplication.class, args);
		Ataque lanzallama = new Ataque(1L, "lanzallama", 15, 5000);
		lanzallama.imprimir();

	}

	
}
