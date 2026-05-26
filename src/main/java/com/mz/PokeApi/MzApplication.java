
package com.mz.PokeApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;
import com.mz.PokeApi.entidades.Peleador;
import com.mz.PokeApi.entidades.Arma;
import com.mz.PokeApi.entidades.Ataque;
import java.util.ArrayList;

@SpringBootApplication
public class MzApplication {

	public static void Luchas(Peleador peleador1, Peleador peleador2) {
		int danio = (peleador1.getataques().get(0).getDanioBase() + peleador1.getArmas().get(0).getBonificadordano());
		if (peleador1.getEnergia() >= peleador1.getataques().get(0).getCostoEnergia()) {
			int vida = (peleador2.getPuntosVida() - danio);
			peleador2.setPuntosVida(vida);
			System.out.println(peleador2.getNombre() + "fue atacado por " + peleador1.getNombre() + " y le quedaron "
					+ vida + " puntos de vida");
		} else {
			System.out.println(peleador1.getNombre() + " está demasiado cansado para atacar");
		}

	}

	public static void Descansar(Peleador peleador1) {
		if (peleador1.getPuntosVida() <= 200) {
			peleador1.setPuntosVida(peleador1.getPuntosVida() + 500);
			peleador1.setEnergia(0);
			System.out.println(peleador1.getNombre() + " descansó y recuperó 500 puntos de vida. Vida actual: "
					+ peleador1.getPuntosVida());
		} else {
			peleador1.setEnergia(peleador1.getEnergia() + 100);
			System.out.println(peleador1.getNombre() + " descansó y recuperó 100 puntos de energía. Energía actual: "
					+ peleador1.getEnergia());
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(MzApplication.class, args);

		Peleador Pikachu = new Peleador(1L, "Pikachu", 100, 50, 10.5f, null, null, null);
		Peleador Charizard = new Peleador(2L, "Charizard", 150, 75, 20.5f, null, null, null);

		int contador = 0;

		Ataque Rayo = new Ataque(1L, "Rayo", 50, 90);
		Ataque LanzaLlamas = new Ataque(2L, "Lanza Llamas", 75, 95);
		Ataque PuñoRayo = new Ataque(3L, "Puño Rayo", 100, 90);

		Arma gemaElectrica = new Arma(1L, "Gema Electrica", 50, 20);
		Arma gemaFuego = new Arma(2L, "Gema Fuego", 50, 30);
		Arma gemaAgua = new Arma(3L, "Gema Agua", 50, 40);
		Arma gemaPlanta = new Arma(4L, "Gema Planta", 50, 50);
		Arma gemaRoca = new Arma(5L, "Gema Roca", 50, 60);
		Arma gemaHielo = new Arma(7L, "Gema Hielo", 50, 80);
		Arma gemaDragon = new Arma(8L, "Gema Dragon", 50, 90);

		Pikachu.setArmas(new ArrayList<>(List.of(gemaElectrica)));
		Charizard.setArmas(new ArrayList<>(List.of(gemaFuego)));

		List<Arma> armas = new ArrayList<>();

		armas.add(gemaAgua);
		armas.add(gemaDragon);
		armas.add(gemaHielo);
		armas.add(gemaPlanta);
		armas.add(gemaRoca);

		List<Ataque> ataques = new ArrayList<>();
		ataques.add(Rayo);
		ataques.add(LanzaLlamas);
		ataques.add(PuñoRayo);

		for (Arma a : armas) {
			Charizard.getArmas().add(a);
		}

		for (Ataque a : ataques) {
			Charizard.getataques().add(a);
		}

		for (Ataque a : Pikachu.getataques()) {
			if (contador < a.getDanioBase()) {
				contador = a.getDanioBase();
			}
		}
		System.out.println("El ataque mas fuerte de Pikachu es: " + contador);

		int contador2 = 0;
		int cantidad = 0;
		for (Ataque a : ataques) {
			cantidad++;
			contador2 = contador2 + a.getCostoEnergia();
		}
		System.out.println("El costo promedio de energia de los ataques es: " + contador2 / cantidad);

		if (Pikachu.getArmas().get(0).getBonificadordano() > Charizard.getArmas().get(0).getBonificadordano()) {
			System.out.println("El arma de pikachu es más fuerte que la de charizard");
		} else if (Pikachu.getArmas().get(0).getBonificadordano() < Charizard.getArmas().get(0).getBonificadordano()) {
			System.out.println("El arma de charizard es más fuerte que la de pikachu");
		}

		for (Ataque a : Pikachu.getataques()) {
			if (Pikachu.getEnergia() >= a.getCostoEnergia()) {
				System.out.println("Pikachu tiene energia suficiente para usar " + a.getNombre() + " con un costo de " + a.getCostoEnergia());
			}
		}

		for (Ataque a : Pikachu.getataques()) {
			for (Ataque a2 : Charizard.getataques()) {
				if (a.getNombre() == a2.getNombre()) {
					a.setDanioBase(a.getDanioBase() + a2.getDanioBase());
				}
			}
		}

		while (Charizard.getPuntosVida() > 0 && Pikachu.getPuntosVida() > 0) {
			if (Charizard.getEnergia() > Charizard.getataques().get(0).getCostoEnergia()) {
				Luchas(Charizard, Pikachu);
			} else {
				Descansar(Charizard);
			}
			if (Pikachu.getPuntosVida() < 0) {
				System.out.println("Charizard gana");
			} else if (Pikachu.getEnergia() > Pikachu.getataques().get(0).getCostoEnergia()) {
				Luchas(Pikachu, Charizard);
			} else {
				Descansar(Pikachu);
			}
			if (Charizard.getPuntosVida() < 0) {
				System.out.println("Pikachu gana");
			}
		}

		System.out.println(Pikachu);
		System.out.println(Charizard);
		System.out.println(Rayo);
		System.out.println(LanzaLlamas);
	}
}
