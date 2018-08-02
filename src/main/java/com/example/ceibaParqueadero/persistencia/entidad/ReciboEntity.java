package com.example.ceibaParqueadero.persistencia.entidad;

import java.util.Calendar;

import javax.persistence.*;


@Entity(name = "Recibo")
public class ReciboEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	//@JoinColumn(name = "ID_VEHICULO" referencedColumnName = "id")
	private VehiculoEntity vehiculoEntity;
	
	@Column(nullable = false)
	private Calendar fechaDeIngreso;
	@Column(nullable = false)
	private Calendar fechaDeSalida;
	@Column
	private double total;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public VehiculoEntity getVehiculoEntity() {
		return vehiculoEntity;
	}
	public void setVehiculoEntity(VehiculoEntity vehiculoEntity) {
		this.vehiculoEntity = vehiculoEntity;
	}
	public Calendar getFechaDeIngreso() {
		return fechaDeIngreso;
	}
	public void setFechaDeIngreso(Calendar fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
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
