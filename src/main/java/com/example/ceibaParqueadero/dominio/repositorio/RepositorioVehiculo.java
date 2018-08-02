package com.example.ceibaParqueadero.dominio.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.example.ceibaParqueadero.persistencia.entidad.VehiculoEntity;

public interface RepositorioVehiculo extends CrudRepository<VehiculoEntity,Long>{
	VehiculoEntity findByPlaca(String placa);

}
