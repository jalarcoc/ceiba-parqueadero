package com.example.ceibaParqueadero.dominio.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.example.ceibaParqueadero.persistencia.entidad.VehiculoEntity;

public interface RepositorioVehiculo extends CrudRepository<VehiculoEntity,Long>{
	
	List<VehiculoEntity> findByPlaca(String placa);
	

}
