package com.example.ceibaParqueadero.dominio.repositorio;



import org.springframework.data.repository.CrudRepository;

import com.example.ceibaParqueadero.persistencia.entidad.ReciboEntity;

public interface RepositorioRecibo extends CrudRepository<ReciboEntity,Long> {
	
	

	
}
