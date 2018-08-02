package com.example.ceibaParqueadero.controladores;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.example.ceibaParqueadero.dominio.Parqueadero;
import com.example.ceibaParqueadero.dominio.Vigilante;

import com.example.ceibaParqueadero.dominio.reglasnegocio.ReglaDisponibilidad;
import com.example.ceibaParqueadero.dominio.reglasnegocio.ReglaPlaca;

import com.example.ceibaParqueadero.dominio.reglasnegocio.ReglasParqueo;
import com.example.ceibaParqueadero.dominio.repositorio.RepositorioRecibos;
import com.example.ceibaParqueadero.dominio.repositorio.RepositorioVehiculos;

@Configuration
public class VigilanteController {
	
	@Autowired
	RepositorioVehiculos repositorioVehiculos;
	@Autowired
	RepositorioRecibos repositorioRecibos;
	
	@Bean
	public Vigilante crearVigilante(){
		return new Vigilante(crearParqueadero(), anadirReglasParcqueo(repositorioRecibos),repositorioVehiculos,repositorioRecibos);
	}

	public Parqueadero crearParqueadero(){
		int celdaCarros=20;
		int celdaMotos=10;
		return new Parqueadero(celdaCarros,celdaMotos);
	}
	
	private List<ReglasParqueo> anadirReglasParcqueo(RepositorioRecibos repositorioRecibos) {
		List<ReglasParqueo> reglasParqueo=new ArrayList<>();
		reglasParqueo.add(new ReglaDisponibilidad(repositorioRecibos));
		reglasParqueo.add(new ReglaPlaca());
		return reglasParqueo;
	}

}