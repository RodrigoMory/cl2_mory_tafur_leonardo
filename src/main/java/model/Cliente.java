package model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "Cliente")
@Entity(name = "Cliente")
@Getter
@Setter
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "apellidoPaterno", length = 255, nullable = false)
	private String apellidoPaterno;
	
	@Column(name = "apellidoMaterno", length = 255, nullable = false)
	private String apellidoMaterno;
	
	@Column(name = "nombres", length = 255, nullable = false)
	private String nombres;
	
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.PERSIST)
    private List<Cuenta> cuentas;
    
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Rol> roles;
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno
				+ ", nombres=" + nombres + "]";
	}
	

}
