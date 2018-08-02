package dominio.logica;


import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import com.example.ceibaParqueadero.dominio.logica.CalcularCobro;

public class CalcularCobroTest {

	private CalcularCobro calcularCobro = new CalcularCobro();
	private Calendar fechaIngreso;
	private Calendar fechaSalida;
	@Test
	public void calcularCobroTestUnaHora(){
		
		fechaIngreso=CrearFecha.crear(2018,8, 01, 13,25);
		fechaSalida=CrearFecha.crear(2018,8, 01, 14,25);
		Assert.assertEquals(calcularCobro.calcular(fechaIngreso, fechaSalida, 2000, 1000), 1000);
	}
	
	@Test
	public void calcularCobroTestMenosDeUnaHora(){
		fechaIngreso=CrearFecha.crear(2018,8, 01, 6,25);
		fechaSalida=CrearFecha.crear(2018,8, 01, 7,24);
		Assert.assertEquals(calcularCobro.calcular(fechaIngreso, fechaSalida, 8000, 1000), 1000);
	}
	@Test
	public void calcularCobroTestUnDiaYTresHoras(){
		fechaIngreso=CrearFecha.crear(2018,8, 01, 6,25);
		fechaSalida=CrearFecha.crear(2018,8, 01, 18,24);
		Assert.assertEquals(calcularCobro.calcular(fechaIngreso, fechaSalida, 8000, 1000), 11000);
	}

}
