package com.example.ceibaParqueadero.dominio.logica;

import java.util.Calendar;

public class CalcularCobro {
	private CalcularDiferenciaEntreFechas calcularTiempoDeEstadia = new CalcularDiferenciaEntreFechas();
	private CalcularDiasDeCobro calcularDiasDeCobro= new CalcularDiasDeCobro();
	private CalcularHorasDeCobro calcularHorasDeCobro = new CalcularHorasDeCobro();
	private long tiempoDeEStadia;
	private int diasDeCobro;
	private int horasDeCobro;
	
	public  int calcular(Calendar fechaDeIngreso, Calendar fechaDeSalida, int valorDias, int valorHoras) {
		calcularTiempoDeEstadia(fechaDeIngreso, fechaDeSalida);
		calcularDiasDeCobro();
		calcularHorasDeCobro();
		return(diasDeCobro*valorDias)+(horasDeCobro*valorHoras); 
	}
 
	private void calcularHorasDeCobro() {
		horasDeCobro=calcularHorasDeCobro.calcular(tiempoDeEStadia);
	}

	private void calcularDiasDeCobro() {
		diasDeCobro=calcularDiasDeCobro.calcular(tiempoDeEStadia);
	}

	private void calcularTiempoDeEstadia(Calendar fechaDeIngreso, Calendar fechaDeSalida) {
		tiempoDeEStadia=calcularTiempoDeEstadia.calcular(fechaDeIngreso, fechaDeSalida);
	}

}
