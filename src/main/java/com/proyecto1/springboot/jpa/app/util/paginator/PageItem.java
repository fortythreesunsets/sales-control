package com.proyecto1.springboot.jpa.app.util.paginator;

public class PageItem {
	private int numero;
	private boolean actual;
	
	//Constructor
	public PageItem(int numero, boolean actual) {
		super();
		this.numero = numero;
		this.actual = actual;
	}

	//Getters
	public int getNumero() {
		return numero;
	}

	public boolean isActual() {
		return actual;
	}
}