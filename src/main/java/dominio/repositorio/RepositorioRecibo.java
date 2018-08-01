package dominio.repositorio;


import java.util.Calendar;
import java.util.List;

import dominio.Recibo;

public interface RepositorioRecibo {
	public void agregarRecibo(Recibo  recibo );
	public Recibo obtenerRecibo(String placa);
	public Long obtenerCantidadDeCeldasOcupadas(String tipo);
	public void actualizarRecibo(String placa,Calendar fechaSalida,int valor);
	public List<Recibo> obtenerListaDeRecibos();

	
}
