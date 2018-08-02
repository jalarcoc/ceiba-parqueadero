package persistencia.builder;

import dominio.Carro;
import dominio.Moto;
import dominio.Vehiculo;
import persistencia.entidad.VehiculoEntity;

public final class VehiculoBuilder {
	
	private VehiculoBuilder(){
		
	}
	public static Vehiculo convertirADominio(VehiculoEntity vehiculoEntity){
		Vehiculo vehiculo = null;
		if(vehiculoEntity != null){
			if(vehiculoEntity.getTipo().equals("carro")){
				vehiculo = new Carro(vehiculoEntity.getPlaca());
			}
			if(vehiculoEntity.getTipo().equals("moto")){
				vehiculo = new Moto(vehiculoEntity.getPlaca(),vehiculoEntity.getCilindraje());
			}
		}
		return vehiculo;
	}
	
	public static VehiculoEntity convertirCarroAEntity(Carro carro) {
		VehiculoEntity vehiculoEntity = new VehiculoEntity();
		vehiculoEntity.setPlaca(carro.getPlaca());
		vehiculoEntity.setTipo(carro.getTipo());
		return vehiculoEntity;
	}
	
	public static VehiculoEntity convertirMotoAEntity(Moto moto) {
		VehiculoEntity vehiculoEntity = new VehiculoEntity();
		vehiculoEntity.setPlaca(moto.getPlaca());
		vehiculoEntity.setTipo(moto.getTipo());
		vehiculoEntity.setCilindraje(moto.getCilindraje());
		return vehiculoEntity;
	}
	
	public static VehiculoEntity convertirVehiculoAEntity(Vehiculo vehiculo){
		VehiculoEntity vehiculoEntity = new VehiculoEntity();
		vehiculoEntity.setPlaca(vehiculo.getPlaca());
		vehiculoEntity.setTipo(vehiculo.getTipo());
		return vehiculoEntity;
	}


}
