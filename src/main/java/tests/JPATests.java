package tests;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.Cliente;
import model.Cuenta;
import model.Movimiento;
import model.Rol;
import model.TipoCuenta;

public class JPATests {

	public static void main(String[] args) throws IOException {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction tx = manager.getTransaction();

		tx.begin();
		
		Cliente cliente = new Cliente();
		cliente.setApellidoPaterno("Mory");
		cliente.setApellidoMaterno("Tafur");
		cliente.setNombres("leonardo");
		
		Cuenta cuenta = new Cuenta();
		cuenta.setNumeroCuenta("1234567890");
		cuenta.setSaldo(5000d);
		cuenta.setActiva(true);
		
		Cuenta cuenta2 = new Cuenta();
		cuenta.setNumeroCuenta("8547589651");
		cuenta.setSaldo(5000d);
		cuenta.setActiva(true);
		
		List<Cuenta> cuentas = new ArrayList<>();
		cliente.setCuentas(cuentas);
		
		TipoCuenta tipoCuenta = new TipoCuenta();
		tipoCuenta.setDescripcion("Cuenta Ahorros");
		tipoCuenta.setMoneda("USD");
		
		Movimiento movimiento = new Movimiento();
		movimiento.setDescripcion("Depósitov inicial");
		movimiento.setFecha(LocalDate.now());
		movimiento.setMonto(500d);
		
		Movimiento movimiento2 = new Movimiento();
		movimiento.setDescripcion("Depósitov a plazo fijo");
		movimiento.setFecha(LocalDate.now());
		movimiento.setMonto(5600d);
		
		List<Movimiento> movimientos = new ArrayList<>();
		cuenta.setMovimientos(movimientos);
		
		Rol rolTitular = new Rol();
		rolTitular.setDescripcion("Titular");
		rolTitular.setActivo(true);
		
		Rol rolBeneficiario = new Rol();
		rolBeneficiario.setDescripcion("Beneficiario");
		rolBeneficiario.setActivo(true);
		
		List<Rol> roles = new ArrayList<>();
		cliente.setRoles(roles);
		
		
		cuenta.setTipoCuenta(tipoCuenta);
		cuenta.getMovimientos().add(movimiento);
		
		cliente.getCuentas().add(cuenta);
		cliente.getRoles().add(rolTitular);
		cliente.getRoles().add(rolBeneficiario);
		
		
		manager.persist(cliente);
		
		tx.commit();
		
		List<Cliente> lista = manager.createQuery("from Cliente", Cliente.class).getResultList();
		for (Cliente c : lista) {
			System.out.println(c);
		}

	}

}
