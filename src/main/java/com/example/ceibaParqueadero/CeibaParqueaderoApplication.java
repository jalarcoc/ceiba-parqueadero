package com.example.ceibaParqueadero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages ={"com.example.ceibaParqueadero.dominio","com.example.ceibaParqueadero.dominio.repositorio","com.example.ceibaParqueadero"})
@EntityScan("com.example.ceibaParqueadero.persistencia.entidad")
public class CeibaParqueaderoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CeibaParqueaderoApplication.class, args);
	} 
}
  