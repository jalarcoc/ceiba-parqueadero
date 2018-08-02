package com.example.ceibaParqueadero.dominio.reglasnegocio;


import org.springframework.beans.factory.annotation.Autowired;

import com.example.ceibaParqueadero.dominio.Carro;
import com.example.ceibaParqueadero.dominio.Moto;
import com.example.ceibaParqueadero.dominio.Parqueadero;
import com.example.ceibaParqueadero.dominio.Vehiculo;
import com.example.ceibaParqueadero.dominio.exception.ParqueoException;
import com.example.ceibaParqueadero.dominio.repositorio.RepositorioRecibos;

public class ReglaDisponibilidad implements ReglasParqueo {
	private static final int LIMITE_CELDAS_PARA_PRESTAR = 0;
	private static final String NO_CAPACIDAD_CARROS = "No hay capacidad para mas carros";
	private static final String NO_CAPACIDAD_MOTOS ="No hay capacidad para mas motos";
	@Autowired
	RepositorioRecibos repositorioRecibos;
	
	public ReglaDisponibilidad(RepositorioRecibos repositorioRecibos){
		this.repositorioRecibos = repositorioRecibos;
		}

	private long celdasNoDisponibles(Vehiculo vehiculo){
		return 0;
	}
	public boolean validar(Vehiculo vehiculo, Parqueadero parqueadero) {
		if(vehiculo instanceof Carro && celdasDisponibles(vehiculo,parqueadero)== LIMITE_CELDAS_PARA_PRESTAR){
			throw new ParqueoException(NO_CAPACIDAD_CARROS);
		}
		if(vehiculo instanceof Moto && celdasDisponibles(vehiculo, parqueadero) == LIMITE_CELDAS_PARA_PRESTAR){
			throw new ParqueoException(NO_CAPACIDAD_MOTOS);
			
		}
		return true;
	}
	
	private int celdasDisponibles(Vehiculo vehiculo, Parqueadero parqueadero) {
		Long celdasOcupadas = celdasNoDisponibles(vehiculo);
		
		if(vehiculo instanceof Carro){
			return parqueadero.getCeldaCarros()-celdasOcupadas.intValue();
		}
		if(vehiculo instanceof Moto){
			return parqueadero.getCeldaMotos()-celdasOcupadas.intValue();
		}
		return 0;
	}

}
