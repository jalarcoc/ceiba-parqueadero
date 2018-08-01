/**
 * 
 */
package dominio.unitaria;


import org.junit.Assert;
import org.junit.Test;

import dominio.Carro;
import dominio.Moto;
import dominio.Vehiculo;

/**
 * @author jessica.alarcon
 *
 */
public class VehiculoTest {
	Vehiculo vehiculo;
	
	@Test
	public void recibirUnCarroTest(){
		
		vehiculo=new Carro("CSR013");
		
		Assert.assertNotNull(vehiculo);
	}
	@Test
	public void recibirUnaMotoTest(){

		vehiculo=new Moto("ZZP35D",150);

		Assert.assertNotNull(vehiculo);
	}
	
}
