package com.example.ceibaParqueadero.dominio.repositorio;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.ceibaParqueadero.persistencia.entidad.ReciboEntity;


public interface RepositorioRecibo extends CrudRepository<ReciboEntity,Long> {
	
	//Recibos por placa
	@Query("SELECT recibo FROM Recibo recibo WHERE recibo.vehiculoEntity.placa = :placa AND recibo.fechaDeSalida is null")
	ReciboEntity obtenerReciboEntity(@Param("placa") String placa);
	
	//Recibos activos
	@Query("SELECT COUNT(*) from Recibo recibo where recibo.vehiculoEntity.tipo = :tipo AND recibo.fechaDeSalida is null")
	Long obtenerCantidadDeCeldasOcupadas(@Param("tipo") String tipo);
	
	//Total vehiculos Activos
	@Query("SELECT recibo from Recibo recibo where recibo.fechaDeSalida is null")
	List<ReciboEntity> listarRecibos();
	
	List<ReciboEntity> findAll();

}

	
	
