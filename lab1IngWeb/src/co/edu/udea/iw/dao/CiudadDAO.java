//Interfaz con los metodos para implementar
package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

/**
 * 
 * @author Juan Diego - diego.goez@udea.edu.co
 * @version 2.0
 *
 */
public interface CiudadDAO {
	//entrega la lista completa de las ciudades en la bases de datos
	public List<Ciudad> obtener() throws MyException;
	
	//Entrega ciudad correspondiente a una clave
	public Ciudad obtener(Long codigo) throws MyException;
}
