package com.cmc.evaluacion.entidades;

public class Random {
	public static int obtenerPosicion() {
		int x = (int) Math.floor(Math.random() * 52);
		return x;
	}
}
