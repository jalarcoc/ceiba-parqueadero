/**
 * 
 */
package com.example.ceibaParqueadero.dominioTest;


import org.junit.Assert;
import org.junit.Test;

import com.example.ceibaParqueadero.dominio.Carro;
import com.example.ceibaParqueadero.dominio.Moto;
import com.example.ceibaParqueadero.dominio.Vehiculo;

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
