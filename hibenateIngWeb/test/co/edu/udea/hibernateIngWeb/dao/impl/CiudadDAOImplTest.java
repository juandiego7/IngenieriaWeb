//Clase de para hacer pruebas con la BD
package co.edu.udea.hibernateIngWeb.dao.impl;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import co.edu.udea.hibenateIngWeb.dao.CiudadDAO;
import co.edu.udea.hibenateIngWeb.dao.CiudadDAOImpl;
import co.edu.udea.hibenateIngWeb.dto.Ciudad;
import co.edu.udea.hibernateIngWeb.exception.MyException;
/**
 * 
 * @author Juan Diego - diego.goez@udea.edu.co
 * @version 2.0
 *
 */

public class CiudadDAOImplTest {
	//probar el metodo para obtener todas las ciudades
	@Test
	public void testObtener() {		
		CiudadDAO ciudadDAO = null;//Declaracion de interfaz para implementar los metodos con la BD
		List<Ciudad> lista = null;//Lista donde se almacenan las ciudades
		
		try {
			ciudadDAO = new CiudadDAOImpl();
			lista = ciudadDAO.obtener();
			assertTrue(lista.size()>0);
		} catch (MyException e) {
			// TODO: handle exception
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	//probar el metodo para obtener una ciudad
	@Test
	public void testObtenerCiudad() {		
		CiudadDAO ciudadDAO = null;//Declaracion de interfaz para implementar los metodos con la BD
		Ciudad ciudad = null;//Objeto donde se almacenan la ciudad
		
		try {
			ciudadDAO = new CiudadDAOImpl();
			ciudad = ciudadDAO.obtener(1L);
			assertTrue(ciudad != null);
		} catch (MyException e) {
			// TODO: handle exception
			fail(e.getMessage());
		}
	}	

}
