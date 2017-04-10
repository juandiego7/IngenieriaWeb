package co.edu.udea.spring.dto;
/**
 * DTO para la tabla Rol
 * @author Juan Diego Goez  - diego.goez@udea.edu.co
 * @version 1.0
 */
public class Rol {
	private String codigo;
	private String nombre;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
