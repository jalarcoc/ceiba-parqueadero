package com.example.ceibaParqueadero.reglasNegocio;

import org.junit.Assert;
import org.junit.Test;

import com.example.ceibaParqueadero.dominio.Carro;
import com.example.ceibaParqueadero.dominio.Parqueadero;
import com.example.ceibaParqueadero.dominio.Vehiculo;
import com.example.ceibaParqueadero.dominio.excepcion.ParqueoException;
import com.example.ceibaParqueadero.dominio.reglasnegocio.ReglaPlaca;
import com.example.ceibaParqueadero.dominio.reglasnegocio.ReglasParqueo;

import static org.mockito.Mockito.*;

public class ReglaPlacaTest {
	Vehiculo vehiculo;
	ReglasParqueo reglas = new ReglaPlaca();
	Parqueadero parqueadero;

	@Test 
	public void PlacaEsAYNoEsDiaHabil() {
		vehiculo = new Carro("ASR013");
		ReglaPlaca reglaPlaca = mock(ReglaPlaca.class);
		when(reglaPlaca.sePuedeIngresar()).thenReturn(true);
		try {
			reglas.validar(vehiculo, parqueadero); 
		} catch (ParqueoException e) {
			Assert.assertEquals("Solo puede ingresar los dias Domingo y Lunes", e.getMessage());
		}

	}

	@Test
	public void PlacaNoEsA() {
		vehiculo = new Carro("CSR013");
		Assert.assertTrue(reglas.validar(vehiculo, parqueadero));

	}

}
