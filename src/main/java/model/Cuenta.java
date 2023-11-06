package model;

import java.math.BigInteger;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "Cuenta")
@Entity(name = "Cuenta")
@Getter
@Setter
public class Cuenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private boolean activa;
	
	@Column(name = "numeroCuenta", length = 255, nullable = false)
	private String numeroCuenta;

	private Double saldo;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private TipoCuenta tipoCuenta;
	
	@OneToMany(mappedBy = "cuenta", cascade = CascadeType.PERSIST)
    private List<Movimiento> movimientos;

	@Override
	public String toString() {
		return "Cuenta [id=" + id + ", activa=" + activa + ", numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + "]";
	}
	
	
}
