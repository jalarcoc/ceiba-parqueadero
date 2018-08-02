package com.example.ceibaParqueadero;


import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import dominio.Parqueadero;
import dominio.Vigilante;
import dominio.repositorio.RepositorioRecibo;
import dominio.repositorio.RepositorioVehiculo;
import reglasnegocio.ReglaDisponibilidad;
import reglasnegocio.ReglaPlaca;

import reglasnegocio.ReglasParqueo;

@Configuration
public class ConfiguracionVigilante {
	

	@Bean
	public Vigilante crearVigilante(RepositorioVehiculo repositorioVehiculo,RepositorioRecibo repositorioRecibo ){
		return new Vigilante(crearParqueadero(), anadirReglasParcqueo(repositorioRecibo),repositorioVehiculo,repositorioRecibo);
	}
	
	public Parqueadero crearParqueadero(){
		int celdaCarros=20;
		int celdaMotos=10;
		return new Parqueadero(celdaCarros,celdaMotos);
	}
	
	private List<ReglasParqueo> anadirReglasParcqueo(RepositorioRecibo repositorioRecibo) {
		List<ReglasParqueo> reglasParqueo=new ArrayList<>();
		reglasParqueo.add(new ReglaDisponibilidad(repositorioRecibo));
		reglasParqueo.add(new ReglaPlaca());
		return reglasParqueo;
	}

	 @Bean
	    public CorsFilter corsFilter() {
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        CorsConfiguration config = new CorsConfiguration();
	        config.setAllowCredentials(true);
	        config.addAllowedOrigin("*");
	        config.addAllowedHeader("*");
	        config.addAllowedMethod("OPTIONS");
	        config.addAllowedMethod("GET");
	        config.addAllowedMethod("POST");
	        config.addAllowedMethod("PUT");
	        config.addAllowedMethod("DELETE");
	        source.registerCorsConfiguration("/**", config);
	        return new CorsFilter(source);
	    }
	

}
