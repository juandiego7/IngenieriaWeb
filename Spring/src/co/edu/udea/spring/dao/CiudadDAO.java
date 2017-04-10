package co.edu.udea.spring.dao;

import java.util.List;

import co.edu.udea.spring.dto.Ciudad;
import co.edu.udea.spring.exception.MyException;

/**
 * Interface para definir los metodos para las Ciudades
 * @author Juan Diego Goez - diego.goez@udea.edu.co
 * @version 1.0
 *
 */

public interface CiudadDAO {
	/**
	 * entrega la lista completa de las ciudades en la bases de datos
	 * @return List de ciudades
	 * @throws MyException
	 */
	public List<Ciudad> obtener() throws MyException;
		
	/**
	 * Entrega ciudad correspondiente a una clave 
	 * @param codigo
	 * @return Ciudad
	 * @throws MyException
	 */
	public Ciudad obtener(Long codigo) throws MyException;
		
	/**
	 * Guarda una nueva ciudad en la BD 
	 * @param ciudad
	 * @throws MyException
	 */
	public void guardar(Ciudad ciudad) throws MyException;
}
