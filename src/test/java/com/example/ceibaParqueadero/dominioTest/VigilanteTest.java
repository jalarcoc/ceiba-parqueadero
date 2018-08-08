package com.example.ceibaParqueadero.dominioTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.ceibaParqueadero.dominio.Carro;
import com.example.ceibaParqueadero.dominio.Moto;
import com.example.ceibaParqueadero.dominio.Recibo;
import com.example.ceibaParqueadero.dominio.Vehiculo;
import com.example.ceibaParqueadero.dominio.Vigilante;
import com.example.ceibaParqueadero.dominio.VigilanteRest;
import com.example.ceibaParqueadero.dominio.repositorio.RepositorioRecibo;
import com.example.ceibaParqueadero.dominio.repositorio.RepositorioVehiculo;
@Import(VigilanteRest.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class VigilanteTest { 
	
	@Autowired
	Vigilante vigilante;
	@Autowired
	RepositorioVehiculo repositorioVehiculo;
	@Autowired
	RepositorioRecibo repositorioRecibo;
	
	private Vehiculo vehiculo;
	
	@Before
	public void limpiarDatos(){
		repositorioRecibo.deleteAll();
		repositorioVehiculo.deleteAll();
		
	}
	
	@Test
	public void existeVehiculoTests(){
		vehiculo=new Carro("FGN887");
		Recibo recibo=vigilante.validarIngresoVehiculo(vehiculo);
		Assert.assertNotNull(recibo);
		Assert.assertTrue(vigilante.existeVehiculo(vehiculo.getPlaca()));
	} 
	
	@Test
	public void ingresarCarroTest(){
		vehiculo=new Carro("FGN887");
		Recibo recibo=vigilante.validarIngresoVehiculo(vehiculo);
		Assert.assertNotNull(recibo);
	}
	
	@Test
	public void ingresarMotoTest(){
		vehiculo=new Moto("FGN887",201);
		Recibo recibo=vigilante.validarIngresoVehiculo(vehiculo);
		Assert.assertNotNull(recibo);
	}
	@Test
	public void noExisteVehiculoTests(){
		vehiculo=new Carro("FGN887");
		Recibo recibo=vigilante.validarIngresoVehiculo(vehiculo);
		vehiculo=new Carro("HGN887");
		Assert.assertNotNull(recibo);
		Assert.assertFalse(vigilante.existeVehiculo(vehiculo.getPlaca()));
	}
	@Test
	public void salidaDeCarroTests(){
		vehiculo=new Carro("FGN887");
		vigilante.validarIngresoVehiculo(vehiculo);
		Recibo reciboSalida=vigilante.darSalidaVehiculo("FGN887");
		Assert.assertNotNull(reciboSalida);
		Assert.assertEquals(reciboSalida.getTotal(),1000, 0);
	}
	@Test
	public void salidaDeMotoCilindraje499Tests(){
		vehiculo=new Moto("FGN887",499);
		vigilante.validarIngresoVehiculo(vehiculo);
		Recibo reciboSalida=vigilante.darSalidaVehiculo("FGN887");
		Assert.assertNotNull(reciboSalida);
		Assert.assertEquals(reciboSalida.getTotal(),500, 0);
	}
	@Test
	public void salidaDeMotoCilindraje500Tests(){
		vehiculo=new Moto("FGN887",500);
		vigilante.validarIngresoVehiculo(vehiculo);
		Recibo reciboSalida=vigilante.darSalidaVehiculo("FGN887");
		Assert.assertNotNull(reciboSalida);
		Assert.assertEquals(reciboSalida.getTotal(),2500, 0);
	}
	
}

