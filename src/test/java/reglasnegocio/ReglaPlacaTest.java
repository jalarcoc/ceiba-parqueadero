package reglasnegocio;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

import dominio.Carro;
import dominio.Parqueadero;
import dominio.Vehiculo;
import dominio.excepcion.ParqueoException;

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
			Assert.assertEquals("Solo puede ingresar los días Domingo y Lunes", e.getMessage());
		}

	}

	@Test
	public void PlacaNoEsA() {
		vehiculo = new Carro("CSR013");
		Assert.assertTrue(reglas.validar(vehiculo, parqueadero));

	}

}
