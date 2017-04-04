package co.edu.udea.spring.dao;

import java.util.List;

import co.edu.udea.spring.dto.Ciudad;
import co.edu.udea.spring.exception.MyException;

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
		
		//Guarda una nueva ciudad en la BD
		public void guardar(Ciudad ciudad) throws MyException;
}
