package com.example.ceibaParqueadero.dominio.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.ceibaParqueadero.persistencia.entidad.ReciboEntity;


public interface RepositorioRecibos extends CrudRepository<ReciboEntity, Long> {
//	ReciboEntity findByPlaca(String placa);
	//long count(String tipo);
	List<ReciboEntity> findAll();
	


}
