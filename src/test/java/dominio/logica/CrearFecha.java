package dominio.logica;

import java.util.Calendar;

public class CrearFecha {
	public static Calendar crear(int anio, int mes, int diaMes, int hora, int minutos) {
		Calendar horaYFecha = Calendar.getInstance();
		horaYFecha.set(Calendar.YEAR, anio);
		horaYFecha.set(Calendar.MONTH, mes);
		horaYFecha.set(Calendar.DAY_OF_MONTH, diaMes);
		horaYFecha.set(Calendar.HOUR_OF_DAY, hora);
		horaYFecha.set(Calendar.MINUTE, minutos);
		horaYFecha.set(Calendar.SECOND, 0);
		horaYFecha.set(Calendar.MILLISECOND, 0);
		return horaYFecha;
	}

}
