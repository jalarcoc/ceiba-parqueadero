package com.example.ceibaParqueadero.dominio.logica;

public class CalcularHorasDeCobro {
	private static final int HORAS_QUE_EQUIVALEN_A_UN_DIA = 9;
	
	public int calcular (long tiempoDeEStadia){
		return (int) (tiempoDeEStadia%HORAS_QUE_EQUIVALEN_A_UN_DIA);
	}
}
