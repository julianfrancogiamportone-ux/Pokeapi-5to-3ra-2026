
package com.mz.PokeApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MzApplication {

	public static void main(String[] args) {
		SpringApplication.run(MzApplication.class, args);
		Arma arma1 = new Arma(1L, "nombre1", 20, 20.0f);
		arma1.imprimir();
	}

}
