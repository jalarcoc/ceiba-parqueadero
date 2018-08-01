package dominio.unitaria;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import dominio.Carro;
import dominio.Recibo;
import dominio.Vehiculo;
import static org.mockito.Mockito.mock;


public class ReciboTest {
	Vehiculo vehiculo;
	@Test
	public void crearReciboIngreso() {

		vehiculo = mock(Vehiculo.class);
		vehiculo = new Carro("CSR013");

		Recibo recibo = new Recibo(vehiculo, Calendar.getInstance());

		Assert.assertNotNull(recibo);
	}

	@Test
	public void crearReciboSalida() {
		
		vehiculo = mock(Vehiculo.class);
		vehiculo = new Carro("CSR013");
		
		Recibo recibo = new Recibo( vehiculo, Calendar.getInstance(), Calendar.getInstance(),  200.0);
		
		Assert.assertNotNull(recibo);
	}


}
