package com.example.ceibaParqueadero.dominio;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.ceibaParqueadero.dominio.reglasnegocio.ReglaCobroCarro;
import com.example.ceibaParqueadero.dominio.reglasnegocio.ReglaCobroMoto;
import com.example.ceibaParqueadero.dominio.reglasnegocio.ReglaDisponibilidad;
import com.example.ceibaParqueadero.dominio.reglasnegocio.ReglaPlaca;
import com.example.ceibaParqueadero.dominio.reglasnegocio.ReglasCobro;
import com.example.ceibaParqueadero.dominio.reglasnegocio.ReglasParqueo;
import com.example.ceibaParqueadero.dominio.repositorio.RepositorioRecibo;
import com.example.ceibaParqueadero.dominio.repositorio.RepositorioVehiculo;

@Configuration
public class VigilanteController {
	
	@Autowired
	RepositorioRecibo repositorioRecibo ;
	@Autowired
	RepositorioVehiculo repositorioVehiculo;
	

	@Bean
	public Vigilante crearVigilante(RepositorioVehiculo repositorioVehiculo,RepositorioRecibo repositorioRecibo ){
		return new Vigilante(crearParqueadero(), anadirReglasParcqueo(repositorioRecibo),repositorioVehiculo,repositorioRecibo,anadirReglasCobro());
	}
	@Bean
	public Parqueadero crearParqueadero(){
		int celdaCarros=20;
		int celdaMotos=10;
		return new Parqueadero(celdaCarros,celdaMotos);
	}
	@Bean
	public List<ReglasParqueo> anadirReglasParcqueo(RepositorioRecibo repositorioRecibo) {
		List<ReglasParqueo> reglasParqueo=new ArrayList<>();
		reglasParqueo.add(new ReglaDisponibilidad(repositorioRecibo));
		reglasParqueo.add(new ReglaPlaca());
		return reglasParqueo;
	}
	@Bean
	public List<ReglasCobro> anadirReglasCobro() {
		List<ReglasCobro> reglasCobro=new ArrayList<>();
		reglasCobro.add(new ReglaCobroCarro());
		reglasCobro.add(new ReglaCobroMoto());
		return reglasCobro;
	}

}
