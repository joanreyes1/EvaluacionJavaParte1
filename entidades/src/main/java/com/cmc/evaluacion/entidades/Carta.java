package com.cmc.evaluacion.entidades;

public class Carta {
	private Numero numero;
	private String palo;
	private String valorInicial = "N";

	public Carta(Numero numero, String palo) {
		super();
		this.numero = numero;
		this.palo = palo;
	}

	public Numero getNumero() {
		return numero;
	}

	public void setNumero(Numero numero) {
		this.numero = numero;
	}

	public String getPalo() {
		return palo;
	}

	public void setPalo(String palo) {
		this.palo = palo;
	}

	public String getBarajado() {
		return valorInicial;
	}

	public void setBarajado(String valorInicial) {
		this.valorInicial = valorInicial;
	}


	@Override
	public String toString() {
		return numero.getNumeroCarta() + "-" + palo;
	}

}
