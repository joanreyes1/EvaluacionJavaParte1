package com.cmc.evaluacion.entidades;

import java.util.ArrayList;

public class Naipe {
	private ArrayList<Numero> numerosPosibles;
	private ArrayList<Carta> cartas = new ArrayList<Carta>();

	public Naipe() {
		numerosPosibles = new ArrayList<Numero>();
		numerosPosibles.add(new Numero("A", 11));
		numerosPosibles.add(new Numero("2", 2));
		numerosPosibles.add(new Numero("3", 3));
		numerosPosibles.add(new Numero("4", 4));
		numerosPosibles.add(new Numero("5", 5));
		numerosPosibles.add(new Numero("6", 6));
		numerosPosibles.add(new Numero("7", 7));
		numerosPosibles.add(new Numero("8", 8));
		numerosPosibles.add(new Numero("9", 9));
		numerosPosibles.add(new Numero("10", 10));
		numerosPosibles.add(new Numero("J", 10));
		numerosPosibles.add(new Numero("Q", 10));
		numerosPosibles.add(new Numero("K", 10));

		for (Numero numero : numerosPosibles) {
			cartas.add(new Carta(numero, Palos.CORAZON_NEGRO));
		}

		for (Numero numero : numerosPosibles) {
			cartas.add(new Carta(numero, Palos.CORAZON_ROJO));
		}

		for (Numero numero : numerosPosibles) {
			cartas.add(new Carta(numero, Palos.DIAMANTE));
		}

		for (Numero numero : numerosPosibles) {
			cartas.add(new Carta(numero, Palos.TREBOL));
		}

	}

	public ArrayList<Carta> getCartas() {
		return cartas;

	}

	public ArrayList<Carta> barajar() {
		ArrayList<Carta> auxiliar = new ArrayList<Carta>();
		for (int i = 1; i < 100; i++) {
			int numero = Random.obtenerPosicion();
			if (cartas.get(numero).getBarajado().equals("N")) {
				auxiliar.add(cartas.get(numero));
				cartas.get(numero).setBarajado("C");
			}
		}

		for (Carta carta : cartas) {
			if (carta.getBarajado().equals("N")) {
				auxiliar.add(carta);
				carta.setBarajado("C");
			}
		}
		return auxiliar;
	}

}
