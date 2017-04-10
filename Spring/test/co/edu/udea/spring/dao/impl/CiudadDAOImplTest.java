package co.edu.udea.spring.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.spring.dao.CiudadDAO;
import co.edu.udea.spring.dto.Ciudad;
import co.edu.udea.spring.exception.MyException;


/**
 * Pruebas de los metodos de CiudadDAO
 * @author Juan Diego Goez - diego.goez@udea.edu.co
 * @version 2.0
 */

/**
 * @author Juan Diego
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)//Correr con otro running
@Transactional//transaccional
@ContextConfiguration(locations="classpath:config.xml")//para saber donde esta el archivo de configuracion de spring para cargarlo
public class CiudadDAOImplTest {

	@Autowired//Inyectar datos desde la base de datos
	CiudadDAO ciudadDAO;
	
	Logger logger = Logger.getLogger(MyException.class);//Para manejar los errores
	
	/**
	 * 
	 * Test method for {@link co.edu.udea.spring.dao.CiudadDAOImpl#obtener()}.
	 * Prueba de obtener()
	 */
	@Test
	public void testObtener() {
		PropertyConfigurator.configure("src/log4j.properties");//propiedades para configurar log4j
		List<Ciudad> lista = null;//Lista donde se almacenan las ciudades
		
		try {
			lista = ciudadDAO.obtener();
			for(Ciudad ciudad: lista){
				System.out.println(ciudad.getCodigo() + ": " + ciudad.getNombre());
			}
			assertTrue(lista.size()>0);
		} catch (MyException e) {
			logger.log(Level.ERROR,"Error consultando: "+ e.getMessage());
		}
	}

	/**
	 * 
	 * Test method for {@link co.edu.udea.spring.dao.CiudadDAOImpl#obtener(java.lang.Long)}.
	 * Prueba de obtener(Long codigo)
	 */
	@Test
	public void testObtenerLong() {
		PropertyConfigurator.configure("src/log4j.properties");//propiedades para configurar log4j
		Ciudad ciudad = null;//Objeto donde se almacenan la ciudad
		try {
			ciudad = ciudadDAO.obtener(2L);
			assertNotNull(ciudad);
			System.out.println(ciudad.getCodigo() + ": " + ciudad.getNombre());
		} catch (MyException e) {
			logger.log(Level.ERROR,"Error consultando long: "+ e.getMessage());
		}
	}
	
	/**
	 * 
	 * Test method for {@link co.edu.udea.spring.dao.CiudadDAOImpl#guardar(co.edu.udea.spring.dto.Ciudad)}.
	 * Prueba de guardar(Ciudad ciudad)
	 */
	@Test
	public void testGuardar() {
		PropertyConfigurator.configure("src/log4j.properties");//propiedades para configurar log4j
		Ciudad ciudad = new Ciudad();//Ciudad que se desea guardar		
		try{
			//setiamos los datos de la nueva ciudad
			ciudad.setCodigo(1L);
			ciudad.setCodigoArea("09");
			ciudad.setNombre("Armenia");
			ciudadDAO.guardar(ciudad); 
			//assertTrue(ciudad != null);
		}catch (MyException e) {
			logger.log(Level.ERROR,"Error guardando: "+ e.getMessage());
		}
	}

}
