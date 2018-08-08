package com.example.ceibaParqueadero.persistencia.entidad;

import java.util.Calendar;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;


@Entity(name = "Recibo")
public class ReciboEntity {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long id;
	@ManyToOne ( cascade = {CascadeType.ALL })
	@JoinColumn(name = "ID_VEHICULO", referencedColumnName = "id")
	private VehiculoEntity vehiculoEntity;
	@Column(nullable = false)
	private Calendar fechaDeIngreso;
	@Column
	private Calendar fechaDeSalida;
	@Column
	private double total; 

	public Calendar getFechaDeIngreso() {
		return fechaDeIngreso;
	}
	public Calendar getFechaDeSalida() {
		return fechaDeSalida;
	}
	public double getTotal() {
		return total;
	}
	public VehiculoEntity getVehiculoEntity() {
		return vehiculoEntity;
	}
	
	public void setFechaDeIngreso(Calendar fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}
	
	public void setFechaDeSalida(Calendar fechaDeSalida) {
		this.fechaDeSalida = fechaDeSalida;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
	public void setVehiculoEntity(VehiculoEntity vehiculoEntity) {
		this.vehiculoEntity = vehiculoEntity;
	}


}
