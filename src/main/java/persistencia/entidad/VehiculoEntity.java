package persistencia.entidad;

import javax.persistence.*;

@Entity(name = "Vehiculo")
@NamedQueries({
		@NamedQuery(name = "Vehiculo.findByPlaca", query = "SELECT vehiculo FROM Vehiculo vehiculo WHERE vehiculo.placa = :placa") })

public class VehiculoEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String placa;
	@Column(nullable = false)
	private String tipo;
	@Column
	private int cilindraje;

	

	
	public Long getId() {
		return id;
	}

	public String getPlaca() {
		return placa;
	}

	public String getTipo() {
		return tipo;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

}
