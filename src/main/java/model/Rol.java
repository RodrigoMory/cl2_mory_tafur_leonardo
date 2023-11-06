package model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "Rol")
@Entity(name = "Rol")
@Getter
@Setter
public class Rol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private boolean activo;
	
	@Column(name = "descripcion", length = 255, nullable = false)
	private String descripcion;

	
	@ManyToMany(mappedBy = "roles", cascade = CascadeType.PERSIST)
    private List<Cliente> clientes;
	
	@Override
	public String toString() {
		return "Rol [id=" + id + ", activo=" + activo + ", descripcion=" + descripcion + "]";
	}

	

}
