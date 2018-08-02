package com.example.ceibaParqueadero;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dominio.Carro;
import dominio.Recibo;
import dominio.Moto;
import dominio.Vehiculo;
import dominio.Vigilante;
import dominio.repositorio.RepositorioRecibo;

@RestController
@Transactional
@RequestMapping(value = "/parqueadero")
@EnableAutoConfiguration
public class VigilanteRest {

	@Autowired
	Vigilante vigilante;
	@Autowired
	RepositorioRecibo repositorioRecibo ;

	@RequestMapping("/")
	public String home() {
		return "vigilante";
	}
	
	@RequestMapping(value = "/ingreso/carro", method = RequestMethod.POST)
	@ResponseBody
	public Recibo servicioIngresarCarro(@RequestBody Carro carro) {
		Vehiculo vehiculo = carro;
		return vigilante.validarIngresoVehiculo(vehiculo);
	}

	@RequestMapping(value = "/ingreso/moto", method = RequestMethod.POST)
	@ResponseBody
	public Recibo servicioIngresarMoto(@RequestBody Moto moto) {
		Vehiculo vehiculo = moto;
		return vigilante.validarIngresoVehiculo(vehiculo);
	}
	@RequestMapping(value = "/listar/vehiculos", method = RequestMethod.GET)
	@ResponseBody
	public List<Recibo> servicioListarVehiculos() {
		return repositorioRecibo.obtenerListaDeRecibos() ;
	}
}
