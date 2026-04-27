
package com.mz.PokeApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.mz.PokeApi.entidades.Peleador;
import com.mz.PokeApi.entidades.Arma;

import com.mz.PokeApi.entidades.Ataque;

@SpringBootApplication
public class MzApplication {

	public static void main(String[] args) {
		SpringApplication.run(MzApplication.class, args);
<<<<<<< gero
		

	}

	
=======
		Peleador peleador1 = new Peleador(1L, "Pikachu", 100, 50, 20.0f, null, null, null);
		peleador1.imprimir();
		Arma arma1 = new Arma(1L, "nombre1", 20, 20.0f);
		arma1.imprimir();
	}


>>>>>>> Develop
}
