package com.proyecto.spring.event.model.response;

public enum Tipo{
	terraza("terraza"), interior("interior"), jardin("jardin");
	
	private String tipo;
	
	
	private Tipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return this.tipo;
	}
}