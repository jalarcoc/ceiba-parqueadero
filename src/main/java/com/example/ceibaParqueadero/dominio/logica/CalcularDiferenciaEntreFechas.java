package com.example.ceibaParqueadero.dominio.logica;

import java.util.Calendar;

public class CalcularDiferenciaEntreFechas {
	private static final int VALOR_DE_MILISEGUNDOS_A_HORAS = 1000*60*60;
	private long miliSegHoraInicial;
	private long miliSegHoraFinal;

	public long calcular(Calendar fechaDeIngreso, Calendar fechaDeSalida) {
		convertirHorasAMilisegundos(fechaDeIngreso, fechaDeSalida);
		return diferenciaEntreFechas();
 
	}

	private long diferenciaEntreFechas() {
		
		double diferencia=(double)(miliSegHoraFinal-miliSegHoraInicial)/VALOR_DE_MILISEGUNDOS_A_HORAS;
		return (long) Math.ceil(diferencia);
	}

	private void convertirHorasAMilisegundos(Calendar fechaDeIngreso, Calendar fechaDeSalida) {
		miliSegHoraInicial = fechaDeIngreso.getTimeInMillis();
		miliSegHoraFinal = fechaDeSalida.getTimeInMillis();
	}

}
