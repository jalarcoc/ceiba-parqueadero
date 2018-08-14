package com.example.ceibaParqueadero.dominio.reglasnegocio;

import java.util.Calendar;

import com.example.ceibaParqueadero.dominio.Parqueadero;
import com.example.ceibaParqueadero.dominio.Vehiculo;
import com.example.ceibaParqueadero.dominio.excepcion.ParqueoException;

public class ReglaPlaca implements ReglasParqueo {
	private static final String NO_ESTA_AUTORIZADO_A_INGRESAR = "Solo puede ingresar los dias Domingo y Lunes";
	
	public boolean validar(Vehiculo vehiculo, Parqueadero parqueadero){
		String placa = vehiculo.getPlaca();
		if(placa.toUpperCase().charAt(0)== 'A' && !sePuedeIngresar()){
			throw new ParqueoException(NO_ESTA_AUTORIZADO_A_INGRESAR);
		}
		return true;
	}
	
	public boolean sePuedeIngresar(){
		int diaLunes = Calendar.MONDAY;
		int diaDomingo = Calendar.SUNDAY;
		int diaActual = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
		return (diaActual == diaLunes || diaActual == diaDomingo);
	}
}
