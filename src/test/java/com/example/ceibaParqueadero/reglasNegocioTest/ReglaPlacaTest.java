package com.example.ceibaParqueadero.reglasNegocioTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.ceibaParqueadero.dominio.Carro;
import com.example.ceibaParqueadero.dominio.Parqueadero;
import com.example.ceibaParqueadero.dominio.Vehiculo;
import com.example.ceibaParqueadero.dominio.exception.ParqueoException;
import com.example.ceibaParqueadero.dominio.reglasnegocio.ReglaPlaca;
import com.example.ceibaParqueadero.dominio.reglasnegocio.ReglasParqueo;
@RunWith(SpringRunner.class)
@SpringBootTest
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
