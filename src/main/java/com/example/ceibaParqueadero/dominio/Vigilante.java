package com.example.ceibaParqueadero.dominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.ceibaParqueadero.dominio.excepcion.ParqueoException;
import com.example.ceibaParqueadero.dominio.reglasnegocio.ReglasCobro;
import com.example.ceibaParqueadero.dominio.reglasnegocio.ReglasParqueo;
import com.example.ceibaParqueadero.dominio.repositorio.RepositorioRecibo;
import com.example.ceibaParqueadero.dominio.repositorio.RepositorioVehiculo;
import com.example.ceibaParqueadero.persistencia.builder.ReciboBuilder;
import com.example.ceibaParqueadero.persistencia.builder.VehiculoBuilder;
import com.example.ceibaParqueadero.persistencia.entidad.ReciboEntity;
import com.example.ceibaParqueadero.persistencia.entidad.VehiculoEntity;
@Component
public class Vigilante {

	private RepositorioVehiculo repositorioVehiculo;
	private RepositorioRecibo repositorioRecibo;
	private Parqueadero parqueadero;
	private List<ReglasParqueo> reglasParqueo;
	private List<ReglasCobro> reglasCobro;
	private static final String NO_PUEDE_INGRESAR = "este vehiculo tiene un recibo sin cobrar";
	private static final String ESTE_VEHICULO_NO_ESTA = "este vehiculo no esta en el sistema";
	private static final String NO_SE_TIENE_COMO_COBRAR = "este vehiculo no es soportado por el sistema";
	private static final String EL_PARQUEADERO_ESTA_VACIO = "el parqueadero esta vacio";


	public Vigilante(Parqueadero parqueadero, List<ReglasParqueo> reglasParqueo,
			RepositorioVehiculo repositorioVehiculo, RepositorioRecibo repositorioRecibo,
			List<ReglasCobro> reglasCobro) {
		this.parqueadero = parqueadero;
		this.reglasParqueo = reglasParqueo;
		this.repositorioVehiculo = repositorioVehiculo;
		this.repositorioRecibo = repositorioRecibo;
		this.reglasCobro = reglasCobro;
	}


	public Recibo validarIngresoVehiculo(Vehiculo vehiculo) {
		validarReglasDeIngreso(vehiculo);
		elVehiculoYaHabiaIngresado(vehiculo);
		if (!validarSiElVehiculoDebeUnRecibo(vehiculo.getPlaca())) {
			Recibo recibo = new Recibo(vehiculo, Calendar.getInstance());
			repositorioRecibo.save(ReciboBuilder.convertirReciboAEntity(recibo));
			return recibo;
		}
		throw new ParqueoException(NO_PUEDE_INGRESAR);


	}
	public Recibo darSalidaVehiculo(String placa) {
		Recibo recibo = obtenerReciboDeEntrada(placa);
		Calendar fechaDeSalida = Calendar.getInstance();
		Vehiculo vehiculo = recibo.getVehiculo();
		ReglasCobro reglaCobro = seleccionarRegla(vehiculo);
		int valorACobrar = reglaCobro.cobrar(recibo, fechaDeSalida);
		recibo.setFechaDeSalida(fechaDeSalida);
		recibo.setTotal(valorACobrar);
		guardarReciboDeSalida(placa, fechaDeSalida, valorACobrar);
		return recibo;

	}
	private void guardarReciboDeSalida(String placa, Calendar fechaDeSalida, int valorACobrar) {
		ReciboEntity reciboEntity = repositorioRecibo.obtenerReciboEntity(placa);
		Recibo recibo = ReciboBuilder.convertirADominio(reciboEntity);
		if(recibo != null){
			recibo.setFechaDeSalida(fechaDeSalida);
			recibo.setTotal(valorACobrar);
			repositorioRecibo.save(ReciboBuilder.convertirReciboAEntity(recibo));
		}

	}
	private ReglasCobro seleccionarRegla(Vehiculo vehiculo) {
		for (ReglasCobro regla : reglasCobro) {
			if (regla.tipoDeCobro().equals(vehiculo.getTipo())) {
				return regla;
			}
		}
		throw new ParqueoException(NO_SE_TIENE_COMO_COBRAR);
	}
	private Recibo obtenerReciboDeEntrada(String placa) {
		ReciboEntity reciboEntity= repositorioRecibo.obtenerReciboEntity(placa);
		Recibo recibo = ReciboBuilder.convertirADominio(reciboEntity);
		if(recibo !=null){ 
			return recibo;
		}
		throw new ParqueoException(ESTE_VEHICULO_NO_ESTA);
		
	}
	public void elVehiculoYaHabiaIngresado(Vehiculo vehiculo) {
		if (!existeVehiculo(vehiculo.getPlaca())) {
			repositorioVehiculo.save(VehiculoBuilder.convertirVehiculoAEntity(vehiculo));
		}
	}

	public void validarReglasDeIngreso(Vehiculo vehiculo) { 
		for (ReglasParqueo regla : reglasParqueo) {
			regla.validar(vehiculo, parqueadero);
		}
	}

	public boolean existeVehiculo(String placa) {
		List<VehiculoEntity> vehiculos = repositorioVehiculo.findByPlaca(placa);
		return  vehiculos != null && !vehiculos.isEmpty();
	}

	public boolean validarSiElVehiculoDebeUnRecibo(String placa) {
		return repositorioRecibo.obtenerReciboEntity(placa) != null;
	}
	
	public Iterable<VehiculoEntity> obtenerVehiculos(){
		return repositorioVehiculo.findAll();
		
	}
	public List<Recibo> obtenerListaDeRecibos(){
		List<ReciboEntity> listaEntity = repositorioRecibo.findAll();
		if(listaEntity!=null){
			List<Recibo> listaRecibos = new ArrayList<>();
			for(ReciboEntity reciboEntity : listaEntity){
				listaRecibos.add(ReciboBuilder.convertirADominio(reciboEntity));
			}
			return listaRecibos;
		}
		throw new ParqueoException(EL_PARQUEADERO_ESTA_VACIO);
	}
}
	 

