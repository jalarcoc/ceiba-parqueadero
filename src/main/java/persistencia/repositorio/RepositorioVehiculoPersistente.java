package persistencia.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import dominio.Carro;
import dominio.Moto;
import dominio.Vehiculo;
import dominio.repositorio.RepositorioVehiculo;
import persistencia.builder.VehiculoBuilder;
import persistencia.entidad.VehiculoEntity;

@Repository
public class RepositorioVehiculoPersistente implements RepositorioVehiculo {

	private static final String PLACA = "placa";
	private static final String VEHICULO_POR_PLACA = "Vehiculo.findByPlaca";
	private EntityManager entityManager;

	public RepositorioVehiculoPersistente(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void agregarCarro(Carro carro) {
		entityManager.persist(VehiculoBuilder.convertirCarroAEntity(carro));

	}

	@Override
	public void agregarMoto(Moto moto) {
		entityManager.persist(VehiculoBuilder.convertirMotoAEntity(moto));
	}
	
	@Override
	public void agregarVehiculo(Vehiculo vehiculo) {
		entityManager.persist(VehiculoBuilder.convertirVehiculoAEntity(vehiculo));
	
	}

	@Override
	public Vehiculo obtenerVehiculo(String placa) {

		VehiculoEntity vehiculoEntity = obtenerVehiculoEntity(placa);
		return VehiculoBuilder.convertirADominio(vehiculoEntity);
	}

	@SuppressWarnings("rawtypes")
	public VehiculoEntity obtenerVehiculoEntity(String placa) {
		Query query = entityManager.createNamedQuery(VEHICULO_POR_PLACA);
		query.setParameter(PLACA, placa);
		List reultList = query.getResultList();
		return !reultList.isEmpty() ? (VehiculoEntity) reultList.get(0) : null;
	}

}
