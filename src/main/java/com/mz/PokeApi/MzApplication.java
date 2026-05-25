
package com.mz.PokeApi;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.mz.PokeApi.entidades.Peleador;
import com.mz.PokeApi.entidades.Arma;
import com.mz.PokeApi.entidades.Ataque;

import java.util.List;
import java.util.ArrayList;

@SpringBootApplication
public class MzApplication {

	public static void golpear(Peleador peleador, Peleador peleador2, Ataque ataque1) {
		if (ataque1.getCostoEnergia() > peleador.getEnergia()) {
			System.out.println("No tienes suficiente energia para realizar este ataque");
		} else {
			int dañot = ataque1.getDanioBase() + (peleador.getArmas().get(0).getBonificadordano());
			int vida = peleador2.getPuntosVida() - dañot;
			peleador2.setPuntosVida(vida);
			System.out.println(peleador2.getNombre() + " tiene " + vida + " puntos de vida");
		}

	}

	public static void descanso(Peleador peleador) {
		if (peleador.getPuntosVida() <= 200 && peleador.getEnergia() >= 100) {
			int vidaf = peleador.getPuntosVida() + 500;
			peleador.setEnergia(0);
			peleador.setPuntosVida(vidaf);
		} else {
			int energf = peleador.getEnergia() + 100;
			peleador.setEnergia(energf);
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(MzApplication.class, args);
		Peleador Pikachu = new Peleador(1L, "Pikachu", 100, 50, 20.0f, null, null, null);
		Peleador Charmander = new Peleador(2L, "Charmander", 120, 40, 10.0f, null, null, null);

		Arma Carbon = new Arma(1L, "Carbon", 20, 20.0f);
		Arma Bandaresistencia = new Arma(2L, "Banda de resistencia", 50, 80.0f);
		Arma Espada = new Arma(3L, "Espada", 25, 10.0f);
		Arma Escudo = new Arma(4L, "Escudo", 30, 20.0f);
		Arma Pistola = new Arma(5L, "Pistola", 60, 40.0f);

		Ataque Boladefuego = new Ataque(1L, "bola de fuego", 15, 20);
		Ataque Rayo = new Ataque(2L, "rayo", 20, 30);
		Ataque Semilla = new Ataque(3L, "semilla", 10, 15);

		System.out.println(Pikachu.getNombre() + " tiene " + Pikachu.getPuntosVida() + " puntos de vida");
		System.out.println(Charmander.getNombre() + " tiene " + Charmander.getPuntosVida() + " puntos de vida");

		Pikachu.setAtaques(new ArrayList<>());
		Charmander.setAtaques(new ArrayList<>());

		Pikachu.setArmas(new ArrayList<>(List.of(Bandaresistencia)));
		Charmander.setArmas(new ArrayList<>(List.of(Carbon)));

		if (Pikachu.getArmas().get(0).getBonificadordano() > Charmander.getArmas().get(0).getBonificadordano()) {
			System.out.println("Pikachu tiene un arma mas fuerte");
		} else if (Pikachu.getArmas().get(0).getBonificadordano() < Charmander.getArmas().get(0).getBonificadordano()) {
			System.out.println("Charmander tiene un arma mas fuerte");
		} else {
			System.out.println("Los peleadores tienen un arma igual de fuerte");
		}

		List<Arma> armas = new ArrayList<>();
		armas.add(Bandaresistencia);
		armas.add(Espada);
		armas.add(Escudo);
		armas.add(Pistola);
		armas.add(Carbon);

		for (Arma a : armas) {
			Pikachu.getArmas().add(a);
			Charmander.getArmas().add(a);
		}

		List<Ataque> ataquesTotales = new ArrayList<>();
		ataquesTotales.add(Boladefuego);
		ataquesTotales.add(Rayo);
		ataquesTotales.add(Semilla);

		for (Ataque a : ataquesTotales) {
			Pikachu.getAtaques().add(a);
			Charmander.getAtaques().add(a);
		}

		int contador = 0;
		String nombreataque = "";
		for (Ataque a : Pikachu.getAtaques()) {
			if (contador < a.getDanioBase()) {
				contador = a.getDanioBase();
				nombreataque = a.getNombre();
			}
		}
		System.out.println("El ataque mas fuerte es: " + nombreataque + " con " + contador + " puntos de daño");

		int engcost = 0;
		int contg = 0;
		for (Ataque a : Pikachu.getAtaques()) {
			engcost += a.getCostoEnergia();
			contg++;
		}
		float promedio = engcost / contg;
		if (promedio >= 50.0f) {
			System.out.println("El promedio de costo de energia de los ataques de Pikachu es mayor a 50");
		} else {
			System.out.println("El promedio de costo de energia de los ataques de Pikachu es menor a 50");
		}

		for (Ataque a : Pikachu.getAtaques()) {
			if (a.getCostoEnergia() <= Pikachu.getEnergia()) {
				System.out.println(a.getNombre());
			}
		}

		descanso(Pikachu);
		descanso(Charmander);
		while (Charmander.getPuntosVida() > 0 && Pikachu.getPuntosVida() > 0) {
			golpear(Pikachu, Charmander, Pikachu.getAtaques().get(0));
			golpear(Charmander, Pikachu, Charmander.getAtaques().get(0));
		}
		if (Pikachu.getPuntosVida() > Charmander.getPuntosVida()) {
			System.out.println("Gano Pikachu");
		} else {
			System.out.println("Gano Charmander");
		}
	}

}
