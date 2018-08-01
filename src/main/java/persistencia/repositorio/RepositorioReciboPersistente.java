package persistencia.repositorio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import dominio.Recibo;
import dominio.excepcion.ParqueoException;
import dominio.repositorio.RepositorioRecibo;
import persistencia.builder.ReciboBuilder;
import persistencia.entidad.ReciboEntity;
import persistencia.entidad.VehiculoEntity;

@Repository
public class RepositorioReciboPersistente implements RepositorioRecibo {
	private static final String PLACA = "placa";
	private static final String TIPO = "tipo";
	private static final String RECIBO_FIND_BY_PLACA = "Recibo.findByPlaca";
	private static final String RECIBOS_ACTIVOS = "Recibo.findRecibosActivos";
	private static final String TOTAL_DE_VEHICULOS_ACTIVOS = "Recibo.findVehuculosActivos";
	private static final String EL_PARQUEADERO_ESTA_VACIO = "el parqueadero esta vacio";

	private EntityManager entityManager;

	public RepositorioReciboPersistente(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void agregarRecibo(Recibo recibo) {
		ReciboEntity reciboEntity = ReciboBuilder.convertirReciboAEntity(recibo);
		RepositorioVehiculoPersistente repositorioVehiculosPersistente = new RepositorioVehiculoPersistente(
				entityManager);
		VehiculoEntity vehiculoEntity = repositorioVehiculosPersistente
				.obtenerVehiculoEntity(recibo.getVehiculo().getPlaca());
		reciboEntity.setVehiculoEntity(vehiculoEntity);
		entityManager.persist(reciboEntity);

	}

	@Override
	public Recibo obtenerRecibo(String placa) {

		ReciboEntity reciboEntity = obtenerReciboEntity(placa);
		Recibo recibo = null;
		if (reciboEntity != null) {
			recibo = ReciboBuilder.convertirADominio(reciboEntity);
		}

		return recibo;

	}

	@SuppressWarnings("rawtypes")
	private ReciboEntity obtenerReciboEntity(String placa) {
		Query query = entityManager.createNamedQuery(RECIBO_FIND_BY_PLACA);
		query.setParameter(PLACA, placa);
		List resultList = query.getResultList();
		return !resultList.isEmpty() ? (ReciboEntity) resultList.get(0) : null;

	}

	@Override
	public Long obtenerCantidadDeCeldasOcupadas(String tipo) {
		Query query = entityManager.createNamedQuery(RECIBOS_ACTIVOS);
		query.setParameter(TIPO, tipo);
		return (Long) query.getSingleResult();

	}

	public void actualizarRecibo(String placa, Calendar fechaSalida, int total) {
		ReciboEntity reciboentity = obtenerReciboEntity(placa);
		if (reciboentity != null) {
			reciboentity.setFechaDeSalida(fechaSalida);
			reciboentity.setTotal(total);
		}

	}

	@Override
	public List<Recibo> obtenerListaDeRecibos() {
		List<ReciboEntity> listaEntity = listarRecibos();
		if(listaEntity!=null){
			List<Recibo> listaRecibos = new ArrayList<>();
			for(ReciboEntity reciboEntity : listaEntity){
				listaRecibos.add(ReciboBuilder.convertirADominio(reciboEntity));
			}
			return listaRecibos;
		}
		throw new ParqueoException(EL_PARQUEADERO_ESTA_VACIO);
	}
	@SuppressWarnings("rawtypes")
	private List<ReciboEntity> listarRecibos() {
		Query query= entityManager.createNamedQuery(TOTAL_DE_VEHICULOS_ACTIVOS);
		List resultList = query.getResultList();
		if(!resultList.isEmpty()){
			return resultList;
		}else{
			return null;
		}
	}

}
