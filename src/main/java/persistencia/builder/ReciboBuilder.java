package persistencia.builder;

import dominio.Carro;
import dominio.Moto;
import dominio.Recibo;
import dominio.Vehiculo;
import persistencia.entidad.ReciboEntity;

public class ReciboBuilder {
	
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
