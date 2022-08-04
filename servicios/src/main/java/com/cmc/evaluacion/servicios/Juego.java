package com.cmc.evaluacion.servicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import com.cmc.evaluacion.entidades.Carta;
import com.cmc.evaluacion.entidades.Naipe;

public class Juego {
	private Naipe naipe;
	private HashMap<String, ArrayList<Carta>> cartasJugador = new HashMap<String, ArrayList<Carta>>();
	private ArrayList<Carta> naipeBarajado = new ArrayList<Carta>();
	private String[] jugadores;

	public HashMap<String, ArrayList<Carta>> getCartasJugador() {
		return cartasJugador;
	}

	public Juego(String[] jugadores) {
		for (int i = 0; i < jugadores.length; i++) {
			cartasJugador.put(jugadores[i], naipeBarajado);
		}
		// cartasJugador.put(jugadores[0], naipeBarajado);
		// cartasJugador.put(jugadores[1], naipeBarajado);
		// cartasJugador.put(jugadores[2], naipeBarajado);
		// cartasJugador.put(jugadores[3], naipeBarajado);
		naipe = new Naipe();
		naipeBarajado = naipe.barajar();
		this.jugadores = jugadores;
	}

	public void entregarCartas(int cartaPorJugador) {

		int posicion = 0;

		ArrayList<Carta> cartasJugador1 = new ArrayList<Carta>();
		ArrayList<Carta> cartasJugador2 = new ArrayList<Carta>();
		ArrayList<Carta> cartasJugador3 = new ArrayList<Carta>();

		for (int i = 1; i <= cartaPorJugador; i++) {
			cartasJugador1.add(naipeBarajado.get(posicion));
			posicion++;
			cartasJugador2.add(naipeBarajado.get(posicion));
			posicion++;
			cartasJugador3.add(naipeBarajado.get(posicion));
			posicion++;
		}

		cartasJugador.put(jugadores[0], cartasJugador1);
		cartasJugador.put(jugadores[1], cartasJugador2);
		cartasJugador.put(jugadores[2], cartasJugador3);

	}

	public int devolverTotal(String idJugador) {
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		cartas = cartasJugador.get(idJugador);
		int sumatotal = 0;
		for (Carta carta : cartas) {
			sumatotal += carta.getNumero().getValor();
		}
		return sumatotal;
	}

	public String determinarGanador() {
		String idGanador = "";
		int sumaGanador = 0;
		for (Entry<String, ArrayList<Carta>> set : cartasJugador.entrySet()) {
			if (devolverTotal(set.getKey()) >= sumaGanador) {
				sumaGanador = devolverTotal(set.getKey());
				idGanador = set.getKey();
			}
		}
		return idGanador;
	}

}