package reglasnegocio;


import dominio.Carro;
import dominio.Moto;
import dominio.Parqueadero;
import dominio.Vehiculo;
import dominio.excepcion.ParqueoException;
import dominio.repositorio.RepositorioRecibo;

public class ReglaDisponibilidad implements ReglasParqueo {
	private static final int LIMITE_CELDAS_PARA_PRESTAR = 0;
	private static final String NO_CAPACIDAD_CARROS = "No hay capacidad para mas carros";
	private static final String NO_CAPACIDAD_MOTOS ="No hay capacidad para mas motos";
	private RepositorioRecibo repositorioRecibo;
	
	public ReglaDisponibilidad(RepositorioRecibo repositorioRecibo){
		this.repositorioRecibo = repositorioRecibo;
	}

	private long celdasNoDisponibles(Vehiculo vehiculo){
		return repositorioRecibo.obtenerCantidadDeCeldasOcupadas(vehiculo.getTipo());
	}
	@Override
	public boolean validar(Vehiculo vehiculo, Parqueadero parqueadero) {
		if(vehiculo instanceof Carro){
			if(celdasDisponibles(vehiculo,parqueadero)== LIMITE_CELDAS_PARA_PRESTAR){
				throw new ParqueoException(NO_CAPACIDAD_CARROS);
			}
		}
		if(vehiculo instanceof Moto){
			if(celdasDisponibles(vehiculo, parqueadero) == LIMITE_CELDAS_PARA_PRESTAR){
				throw new ParqueoException(NO_CAPACIDAD_MOTOS);
			}
		}
		return true;
	}
	
	private int celdasDisponibles(Vehiculo vehiculo, Parqueadero parqueadero) {
		Long celdasOcupadas = celdasNoDisponibles(vehiculo);
		
		if(vehiculo instanceof Carro){
			return parqueadero.getCeldaCarros()-celdasOcupadas.intValue();
		}
		if(vehiculo instanceof Moto){
			return parqueadero.getCeldaMotos()-celdasOcupadas.intValue();
		}
		return 0;
	}

}
