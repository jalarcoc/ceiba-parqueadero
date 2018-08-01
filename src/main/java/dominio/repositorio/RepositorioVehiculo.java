package dominio.repositorio;

import dominio.Carro;
import dominio.Moto;
import dominio.Vehiculo;

public interface RepositorioVehiculo {
	
	public void agregarCarro(Carro carro);
	public void agregarMoto(Moto moto);
	public Vehiculo obtenerVehiculo(String placa);
	
	void agregarVehiculo(Vehiculo vehiculo);

}
