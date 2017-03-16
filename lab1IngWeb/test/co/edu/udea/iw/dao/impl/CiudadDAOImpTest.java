//Clase de para hacer pruebas con la BD
package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;
/**
 * 
 * @author Juan Diego
 * @version 2.0
 *
 */

public class CiudadDAOImpTest {
	//probar el metodo para obtener toda las ciudades
	@Test
	public void testObtener() {		
		CiudadDAO ciudadDAO = null;//Declaracion de interfaz para implementar los metodos con la BD
		List<Ciudad> lista = null;//Lista donde se almacenan las ciudades
		
		try {
			ciudadDAO = new CiudadDAOImp();
			lista = ciudadDAO.obtener();
			assertTrue(lista.size()>0);
		} catch (MyException e) {
			// TODO: handle exception
			fail(e.getMessage());
		}
	}
	//probar el metodo para obtener una ciudad
	@Test
	public void testObtenerCiudad() {		
		CiudadDAO ciudadDAO = null;//Declaracion de interfaz para implementar los metodos con la BD
		Ciudad ciudad = null;//Objeto donde se almacenan la ciudad
		
		try {
			ciudadDAO = new CiudadDAOImp();
			ciudad = ciudadDAO.obtener(1L);
			assertTrue(ciudad != null);
		} catch (MyException e) {
			// TODO: handle exception
			fail(e.getMessage());
		}
	}

}
