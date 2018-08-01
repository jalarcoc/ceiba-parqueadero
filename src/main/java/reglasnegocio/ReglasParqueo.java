package reglasnegocio;

import dominio.Parqueadero;
import dominio.Vehiculo;

public interface ReglasParqueo {
	public boolean validar (Vehiculo vehiculo, Parqueadero parqueadero);

}
