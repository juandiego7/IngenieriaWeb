package co.edu.udea.hibenateIngWeb.dao;

import java.util.List;
import co.edu.udea.hibenateIngWeb.dto.Ciudad;
import co.edu.udea.hibernateIngWeb.exception.MyException;

/**
 * 
 * @author diego.goez
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
