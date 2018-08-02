package com.example.ceibaParqueadero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages ={"dominio","persistencia.repositorio","com.example.ceibaParqueadero"})
@EntityScan("persistencia.entidad")
public class CeibaParqueaderoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CeibaParqueaderoApplication.class, args);
	}
}
