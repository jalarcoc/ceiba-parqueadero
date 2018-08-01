package reglasnegocio;

import java.util.Calendar;

import dominio.Parqueadero;
import dominio.Vehiculo;
import dominio.excepcion.ParqueoException;

public class ReglaPlaca implements ReglasParqueo {
	private static final String NO_ESTA_AUTORIZADO_A_INGRESAR = "Solo puede ingresar los días Domingo y Lunes";
	
	
	public boolean sePuedeIngresar(){
		int diaDomingo = Calendar.SUNDAY;
		int diaLunes = Calendar.MONDAY;
		int diaActual = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
		return diaActual == diaDomingo || diaActual == diaLunes;
	}
	public boolean validar(Vehiculo vehiculo, Parqueadero parqueadero){
		String placa = vehiculo.getPlaca();
		if(placa.charAt(0)== 'A' && !sePuedeIngresar()){
			throw new ParqueoException(NO_ESTA_AUTORIZADO_A_INGRESAR);
		}
		return true;
	}
	

}
