package dominio.repositorio;

import java.util.List;

import dominio.Recibo;

public interface RepositorioRecibo {
	public void agregarRecibo(Recibo recibo);
	public Recibo obtenerRecibo(String placa);
	public Long obtenerCantidadDeCeldasOcupadas(String tipo);
	List<Recibo> obtenerListaDeRecibos();
	
}
