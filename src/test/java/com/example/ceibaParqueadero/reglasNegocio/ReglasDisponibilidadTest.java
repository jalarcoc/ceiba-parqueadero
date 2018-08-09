package com.example.ceibaParqueadero.reglasNegocio;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.ceibaParqueadero.CeibaParqueaderoApplication;
import com.example.ceibaParqueadero.dominio.Carro;
import com.example.ceibaParqueadero.dominio.Moto;
import com.example.ceibaParqueadero.dominio.Parqueadero;
import com.example.ceibaParqueadero.dominio.Vehiculo;
import com.example.ceibaParqueadero.dominio.VigilanteRest;
import com.example.ceibaParqueadero.dominio.excepcion.ParqueoException;
import com.example.ceibaParqueadero.dominio.reglasnegocio.ReglaDisponibilidad;
import com.example.ceibaParqueadero.dominio.repositorio.RepositorioRecibo;

@Import(VigilanteRest.class)
@RunWith(SpringRunner.class)
@SpringBootTest(classes={CeibaParqueaderoApplication.class})
@DataJpaTest
public class ReglasDisponibilidadTest {
	
	@Autowired
	RepositorioRecibo repositorioRecibo;
	@Autowired
	ReglaDisponibilidad reglas;
	@Autowired
	Parqueadero parqueadero;
	
	private Vehiculo vehiculo;

	@Test
	public void validarDisponibilidadCeldaMotoTest() {
		vehiculo = new Moto("ZZP30D", 180);
		parqueadero = new Parqueadero(20, 10);
		reglas = new ReglaDisponibilidad(repositorioRecibo);
		Assert.assertTrue(reglas.validar(vehiculo, parqueadero));
	}
	
	@Test
	public void validarDisponibilidadCeldaCarroTest(){
		vehiculo = new Carro("JJP112");
		parqueadero = new Parqueadero(20, 10);
		reglas = new ReglaDisponibilidad(repositorioRecibo);
		Assert.assertTrue(reglas.validar(vehiculo, parqueadero));
	}
	@Test
	public void validarNoDisponibilidadCeldaMotoTest(){
		vehiculo = new Moto("ZZP30D", 180);
		parqueadero = new Parqueadero(20, 0);
		reglas = new ReglaDisponibilidad(repositorioRecibo);
		try{
			reglas.validar(vehiculo, parqueadero);
		}catch(ParqueoException e){ 
			Assert.assertEquals("No hay capacidad para mas motos", e.getMessage());
		}

	}
	@Test
	public void validarNoDisponibilidadCeldaCarroTest(){
		vehiculo = new Carro("JJP112");
		parqueadero = new Parqueadero(0, 10);
		reglas = new ReglaDisponibilidad(repositorioRecibo);
		try{
			reglas.validar(vehiculo, parqueadero);
		}catch(ParqueoException e){
			Assert.assertEquals("No hay capacidad para mas carros", e.getMessage());
			
		}
	}

}
