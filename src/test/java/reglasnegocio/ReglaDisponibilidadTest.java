package reglasnegocio;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.ceibaparqueadero.CeibaparqueaderoApplication;

import dominio.Carro;
import dominio.Moto;
import dominio.Parqueadero;
import dominio.Vehiculo;
import dominio.excepcion.ParqueoException;
import dominio.repositorio.RepositorioRecibo;
@RunWith(SpringRunner.class)
@SpringBootTest(classes={CeibaparqueaderoApplication.class})
@DataJpaTest
public class ReglaDisponibilidadTest {
	@Autowired
	RepositorioRecibo repositorioRecibo;
	Vehiculo vehiculo;
	ReglaDisponibilidad reglas;
	Parqueadero parqueadero;

	@Test
	public void validarDisponibilidadMoto() {
		vehiculo = new Moto("CSR013", 150);
		parqueadero = new Parqueadero(20, 10);
		reglas = new ReglaDisponibilidad(repositorioRecibo);
		Assert.assertTrue(reglas.validar(vehiculo, parqueadero));

	}

	@Test
	public void validarDisponibilidadCarro() {
		vehiculo = new Carro("CSR013");
		parqueadero = new Parqueadero(20, 10);
		reglas = new ReglaDisponibilidad(repositorioRecibo);
		Assert.assertTrue(reglas.validar(vehiculo, parqueadero));
	}

	@Test
	public void validarDisponibilidadMotoFalso() {
		vehiculo = new Moto("CSR013", 150);
		parqueadero = new Parqueadero(20, 0);
		reglas = new ReglaDisponibilidad(repositorioRecibo);
		try {
			reglas.validar(vehiculo, parqueadero);
			fail();

		} catch (ParqueoException e) {
			Assert.assertEquals("No hay capacidad para mas motos", e.getMessage());
		}

	}

	@Test
	public void validarDisponibilidadCarroFalso() {
		vehiculo = new Carro("CSR013");
		parqueadero = new Parqueadero(0, 10);
		reglas = new ReglaDisponibilidad(repositorioRecibo);
		try {
			reglas.validar(vehiculo, parqueadero);
			fail();

		} catch (ParqueoException e) {
			Assert.assertEquals("No hay capacidad para mas carros", e.getMessage());
		}

	}

}
