package com.example.ceibaParqueadero.dominio.reglasnegocio;

import java.util.Calendar;

import com.example.ceibaParqueadero.dominio.Recibo;
import com.example.ceibaParqueadero.dominio.logica.CalcularCobro;

public class ReglaCobroCarro implements ReglasCobro{
	private static final int VALORDIA = 8000;
	private static final int VALORHORA = 1000;
	private static final String COBROPARACARRO = "carro";
	private CalcularCobro calcularCobro = new CalcularCobro();
	
	@Override
	public int cobrar(Recibo recibo, Calendar fechaDeSalida) {
		return calcularCobro.calcular(recibo.getFechaIngreso(),fechaDeSalida, VALORDIA,VALORHORA);
	}
	@Override
	public String tipoDeCobro(){
		return COBROPARACARRO;
	}
}
 