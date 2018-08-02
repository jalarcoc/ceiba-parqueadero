package com.example.ceibaParqueadero.dominio.reglasnegocio;

import java.util.Calendar;

import com.example.ceibaParqueadero.dominio.Recibo;

public interface ReglasCobro {
	
	public int cobrar(Recibo recibo, Calendar fechaDeSalida);
	public String tipoDeCobro();

}
