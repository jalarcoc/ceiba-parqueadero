package com.example.ceibaParqueadero.dominio;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.example.ceibaParqueadero.dominio.exception.ParqueoException;
import com.example.ceibaParqueadero.dominio.reglasnegocio.ReglasParqueo;
import com.example.ceibaParqueadero.dominio.repositorio.RepositorioRecibos;
import com.example.ceibaParqueadero.dominio.repositorio.RepositorioVehiculos;
import com.example.ceibaParqueadero.persistencia.builder.ReciboBuilder;
import com.example.ceibaParqueadero.persistencia.builder.VehiculoBuilder;

public class Vigilante {
	private Parqueadero parqueadero;
	private List<ReglasParqueo> reglasParqueo;
	private static final String NO_PUEDE_INGRESAR = "este vehiculo tiene un recibo sin cobrar";

	@Autowired
	RepositorioVehiculos repositorioVehiculos;
	@Autowired
	RepositorioRecibos repositorioRecibos;

	
	public Vigilante(Parqueadero parqueadero, List<ReglasParqueo> reglasParqueo,
			RepositorioVehiculos repositorioVehiculos, RepositorioRecibos repositorioRecibos) {
		super(); 
		this.parqueadero = parqueadero;
		this.reglasParqueo = reglasParqueo;
		this.repositorioVehiculos = repositorioVehiculos;
		this.repositorioRecibos = repositorioRecibos;
	}
	public Recibo validarIngresoVehiculo(Vehiculo vehiculo) {
		validarReglasDeIngreso(vehiculo);
		elVehiculoYaHabiaIngresado(vehiculo);
		if (!validarSiElVehiculoDebeUnRecibo(vehiculo.getPlaca())) {
			Recibo recibo = new Recibo(vehiculo, Calendar.getInstance());
			repositorioRecibos.save(ReciboBuilder.convertirReciboAEntity(recibo));
			return recibo;
		}
		throw new ParqueoException(NO_PUEDE_INGRESAR);

	}
	public void elVehiculoYaHabiaIngresado(Vehiculo vehiculo) {
		if (!existeVehiculo(vehiculo.getPlaca())) {
			repositorioVehiculos.save(VehiculoBuilder.convertirVehiculoAEntity(vehiculo));
		}
	}

	public void validarReglasDeIngreso(Vehiculo vehiculo) {
		for (ReglasParqueo regla : reglasParqueo) {
			regla.validar(vehiculo, parqueadero);
		}
	}

	public boolean existeVehiculo(String placa) {
		return repositorioVehiculos.findByPlaca(placa) != null;
	}

	public boolean validarSiElVehiculoDebeUnRecibo(String placa) {
//		return repositorioRecibos.findByPlaca(placa) != null;
		return true;

	}

}
