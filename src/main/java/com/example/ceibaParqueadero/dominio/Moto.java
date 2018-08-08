package com.example.ceibaParqueadero.dominio;

public class Moto extends Vehiculo {
	private int cilindraje;
	
	public Moto(){
		this.tipo = "moto";
	}
	
	public Moto(String placa, int cilindraje){
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.tipo = "moto";	
		
	}
	public int getCilindraje() {
		return cilindraje;
	}
}
 