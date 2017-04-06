package co.edu.udea.spring.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.spring.dao.CiudadDAO;
import co.edu.udea.spring.dao.CiudadDAOImpl;
import co.edu.udea.spring.dto.Ciudad;
import co.edu.udea.spring.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)//Correr con otro running
@Transactional//transsacional
@ContextConfiguration(locations="classpath:config.xml")//para saber donde esta el archivo de configuracion de spring para cargarlo
public class CiudadDAOImplTest {

	@Autowired//inyectar datos desde la base de datos
	CiudadDAO ciudadDAO;
	
	@Test
	public void testObtener() {
		
		List<Ciudad> lista = null;//Lista donde se almacenan las ciudades
		
		try {
			lista = ciudadDAO.obtener();
			assertTrue(lista.size()>0);
		} catch (MyException e) {
			// TODO: handle exception
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testObtenerLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testGuardar() {
		fail("Not yet implemented");
	}

}
