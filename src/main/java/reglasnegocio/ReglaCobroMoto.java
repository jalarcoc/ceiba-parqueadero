package reglasnegocio;

import java.util.Calendar;

import dominio.Moto;
import dominio.Recibo;
import dominio.logica.CalcularCobro;

public class ReglaCobroMoto implements ReglasCobro {
	private static final int VALORHORA = 500;
	private static final int VALORDIA = 4000;
	private static final int EXCEDENTECILINDRAJE = 500;
	private static final int COBROPORCILINDRAJE = 2000; 
	private static final String COBROPARAMOTO = "moto";
	private CalcularCobro calcularCobro = new CalcularCobro();
	Moto moto;
	
	@Override
	public int cobrar(Recibo recibo, Calendar fechaDeSalida) {
		moto = (Moto)recibo.getVehiculo();
		if(moto.getCilindraje()>= EXCEDENTECILINDRAJE){
			return((calcularCobro.calcular(recibo.getFechaIngreso(), fechaDeSalida, VALORDIA, VALORHORA))+ COBROPORCILINDRAJE);
		}
		return calcularCobro.calcular(recibo.getFechaIngreso(), fechaDeSalida, VALORDIA, VALORHORA);
	}
	@Override
	public String tipoDeCobro() {
		return COBROPARAMOTO;
	}

}
