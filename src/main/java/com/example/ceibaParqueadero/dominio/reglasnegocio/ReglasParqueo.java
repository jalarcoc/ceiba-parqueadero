package com.example.ceibaParqueadero.dominio.reglasnegocio;

import com.example.ceibaParqueadero.dominio.Parqueadero;
import com.example.ceibaParqueadero.dominio.Vehiculo;

public interface ReglasParqueo {
	public boolean validar (Vehiculo vehiculo, Parqueadero parqueadero);

}
