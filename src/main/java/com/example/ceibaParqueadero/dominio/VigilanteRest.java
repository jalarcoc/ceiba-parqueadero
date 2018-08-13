package com.example.ceibaParqueadero.dominio;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ceibaParqueadero.dominio.logica.SalidaDeVehiculos;
import com.example.ceibaParqueadero.dominio.repositorio.RepositorioRecibo;

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
	@CrossOrigin(origins = "http://localhost:4200")
	public Recibo servicioIngresarCarro(@RequestBody Carro carro) {
		Vehiculo vehiculo = carro;
		return vigilante.validarIngresoVehiculo(vehiculo);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/ingreso/moto", method = RequestMethod.POST)
	@ResponseBody
	public Recibo servicioIngresarMoto(@RequestBody Moto moto) {
		Vehiculo vehiculo = moto;
		return vigilante.validarIngresoVehiculo(vehiculo);
	}
	@RequestMapping(value = "/listar/vehiculos", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Recibo> servicioListarVehiculos() {
		return vigilante.obtenerListaDeRecibos() ;
	}
	@RequestMapping(value = "/cobro/vehiculo", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin(origins = "http://localhost:4200")
	public Recibo servicioCobrarVehiculo(@RequestBody SalidaDeVehiculos placa) {
		return vigilante.darSalidaVehiculo(placa.getPlaca());
	}
}
