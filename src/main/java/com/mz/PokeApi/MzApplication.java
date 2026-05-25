
package com.mz.PokeApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.mz.PokeApi.entidades.Peleador;
import com.mz.PokeApi.entidades.Arma;

import com.mz.PokeApi.entidades.Ataque;
import java.util.List;
import java.util.ArrayList;

@SpringBootApplication
public class MzApplication {

	public static void golpe(Peleador peleador, Peleador peleador2) {
		if (peleador.getEnergia() >= peleador.getAtaques().get(0).getCostoEnergia()) {
			int danio = peleador.getAtaques().get(0).getDanioBase() + peleador.getArmas().get(0).getBonificadordano();
			int vida = peleador2.getPuntosVida() - danio;
			peleador2.setPuntosVida(vida);
			if (peleador2.getPuntosVida() > 0) {
				System.out
						.println(peleador.getNombre() + " ataca a " + peleador2.getNombre() + " con "
								+ peleador.getAtaques().get(0).getNombre());
				System.out.println(peleador2.getNombre() + "tiene" + vida + " de vida");
			} else {
				System.out.println(peleador.getNombre() + " ataca a " + peleador2.getNombre() + " con "
						+ peleador.getAtaques().get(0).getNombre());
				System.out.println(peleador2.getNombre() + " ya no le quedan puntos de vidas");
			}
		} else {
			System.out.println(peleador.getNombre() + " no tiene suficiente energia para atacar");
		}
	}

	public static void descansar(Peleador peleador) {
		if (peleador.getPuntosVida() < 200 && peleador.getEnergia() > 100) {
			peleador.setPuntosVida(peleador.getPuntosVida() + 500);
			peleador.setEnergia(0);
			System.out.println("descansando");
		} else {
			peleador.setEnergia(100);
			System.out.println("energia recuperada");
		}

	}

	public static void main(String[] args) {
		SpringApplication.run(MzApplication.class, args);

		Peleador charizard = new Peleador(1L, "Charizard", 1, 80, 70f, null, null, null);
		Peleador pikachu = new Peleador(2L, "Pikachu", 220, 100, 70f, null, null, null);
		Ataque bolaFuego = new Ataque(1L, "Bola de Fuego", 70, 60);
		Ataque rayo = new Ataque(2L, "Rayo", 50, 50);
		Ataque chorroAgua = new Ataque(3L, "Chorro de Agua", 60, 55);
		Arma espada = new Arma(1L, "Espada", 20, 30);
		Arma escudo = new Arma(2L, "Escudo", 10, 20);
		Arma carbon = new Arma(3L, "Carbon", 150, 10);
		Arma lanza = new Arma(4L, "Lanza", 5, 10);
		Arma vidaesfera = new Arma(5L, "Vidaesfera", 50, 5);
		List<Ataque> xd = new ArrayList<>();
		charizard.imprimirvida();
		pikachu.imprimirvida();
		pikachu.setArmas(new ArrayList<>(List.of(escudo)));
		charizard.setArmas(new ArrayList<>(List.of(espada)));
		charizard.setAtaques(xd);
		pikachu.setAtaques(new ArrayList<>(List.of(rayo)));
		if (charizard.getArmas().get(0).getBonificadordano() > pikachu.getArmas().get(0).getBonificadordano()) {
			System.out.println("Charizard tiene una espada mas grande");
		} else {
			System.out.println("Pikachu tiene una espada mas grande");
		}
		List<Arma> armas = new ArrayList<>();
		armas.add(espada);
		armas.add(escudo);
		armas.add(lanza);
		armas.add(carbon);
		armas.add(vidaesfera);

		for (Arma a : armas) {
			charizard.getArmas().add(a);
		}

		for (Arma a : charizard.getArmas()) {
			System.out.println("Charizard tiene: " + a.getNombre());
		}

		List<Ataque> ataques = new ArrayList<>();
		ataques.add(bolaFuego);
		ataques.add(chorroAgua);
		ataques.add(rayo);

		for (Ataque a : ataques) {
			charizard.getAtaques().add(a);
		}

		int i = 0;
		String nombre = "";

		for (Ataque a : charizard.getAtaques()) {
			if (i < a.getDanioBase()) {
				i = a.getDanioBase();
				nombre = a.getNombre();
			}
		}
		System.out.println("El ataque mas fuerte de charizard es: " + nombre + " con un daño de: " + i);
		int costo = 0;
		for (Ataque a : charizard.getAtaques()) {
			costo += a.getCostoEnergia();
		}
		int promedio = costo / charizard.getAtaques().size();
		if (promedio > 50) {
			System.out.println("Charizard tiene un gasto de energia alto, el costo promedio es de: " + promedio);
		} else {
			System.out.println("Charizard tiene un gasto de energia bajo, el costo promedio es de: " + promedio);
		}
		golpe(charizard, pikachu);
		descansar(pikachu);
		descansar(charizard);
		for (Ataque a : charizard.getAtaques()) {
			if (charizard.getEnergia() >= a.getCostoEnergia()) {
				System.out.println("charizard puede usar" + a.getNombre());
			} else {
				System.out.println("charizard no puede usar" + a.getNombre());
			}
		}
		while (charizard.getPuntosVida() > 0 && pikachu.getPuntosVida() > 0) {
			if (charizard.getEnergia() > charizard.getAtaques().get(0).getCostoEnergia()) {
				golpe(charizard, pikachu);
			} else {
				descansar(charizard);
			}
			if (pikachu.getPuntosVida() < 0) {
				System.out.println("charizard gana");
			} else if (pikachu.getEnergia() > pikachu.getAtaques().get(0).getCostoEnergia()) {
				golpe(pikachu, charizard);
			} else {
				descansar(charizard);
			}
			if (charizard.getPuntosVida() < 0) {
				System.out.println("pikachu gana");
			}

		}

	}

}
