package com.example.ceibaParqueadero.dominio;

import java.util.Calendar;

public class Recibo {
	private Vehiculo vehiculo;
	private Calendar fechaIngreso;
	private Calendar fechaDeSalida;
	private double total;
	
	public Recibo(Vehiculo vehiculo, Calendar fechaIngreso) {
		super();
		this.vehiculo = vehiculo;
		this.fechaIngreso = fechaIngreso;
	}

	public Recibo(Vehiculo vehiculo, Calendar fechaIngreso, Calendar fechaDeSalida, double total) {
		super();
		this.vehiculo = vehiculo;
		this.fechaIngreso = fechaIngreso;
		this.fechaDeSalida = fechaDeSalida;
		this.total = total;
	}
	
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo; 
	}
	public Calendar getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Calendar fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Calendar getFechaDeSalida() {
		return fechaDeSalida;
	}
	public void setFechaDeSalida(Calendar fechaDeSalida) {
		this.fechaDeSalida = fechaDeSalida;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

		
}
