package reglasnegocio;

import java.util.Calendar;

import dominio.Recibo;

public interface ReglasCobro {
	
	public int cobrar(Recibo recibo, Calendar fechaDeSalida);
	public String tipoDeCobro();

}
