package com.example.ceibaParqueadero.persistencia.builder;

import com.example.ceibaParqueadero.dominio.Carro;
import com.example.ceibaParqueadero.dominio.Moto;
import com.example.ceibaParqueadero.dominio.Recibo;
import com.example.ceibaParqueadero.dominio.Vehiculo;
import com.example.ceibaParqueadero.persistencia.entidad.ReciboEntity;

public final class ReciboBuilder {
	
	private ReciboBuilder(){
		
	}
	public static ReciboEntity convertirReciboAEntity(Recibo recibo){
		ReciboEntity reciboEntity = new ReciboEntity();
		reciboEntity.setFechaDeIngreso(recibo.getFechaIngreso());
		reciboEntity.setFechaDeSalida(recibo.getFechaSalida());
		reciboEntity.setTotal(recibo.getTotal());
		
		if(recibo.getVehiculo() instanceof Carro){
			Carro carro = (Carro) recibo.getVehiculo();
			reciboEntity.setVehiculoEntity(VehiculoBuilder.convertirCarroAEntity(carro));
		}
		if(recibo.getVehiculo() instanceof Moto){
			Moto moto = (Moto) recibo.getVehiculo();
			reciboEntity.setVehiculoEntity(VehiculoBuilder.convertirMotoAEntity(moto));
		}
		return reciboEntity;
	}
	
	public static Recibo convertirADominio(ReciboEntity reciboEntity){
		Vehiculo vehiculo = VehiculoBuilder.convertirADominio(reciboEntity.getVehiculoEntity());
		return new Recibo(vehiculo, reciboEntity.getFechaDeIngreso());
	}

}
