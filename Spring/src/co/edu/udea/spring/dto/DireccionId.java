package co.edu.udea.spring.dto;

import java.io.Serializable;
/**
 * Clave foranea de la tabla Direccion
 * @author Juan Diego Goez  - diego.goez@udea.edu.co
 * @version 1.0
 */

public class DireccionId implements Serializable{
	private Long codigo;
	private Cliente cliente;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}