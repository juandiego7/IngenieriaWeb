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
import co.edu.udea.spring.dto.Ciudad;
import co.edu.udea.spring.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)//Correr con otro running
@Transactional//transaccional
@ContextConfiguration(locations="classpath:config.xml")//para saber donde esta el archivo de configuracion de spring para cargarlo
public class CiudadDAOImplTest {

	@Autowired//Inyectar datos desde la base de datos
	CiudadDAO ciudadDAO;
	
	@Test
	public void testObtener() {
		List<Ciudad> lista = null;//Lista donde se almacenan las ciudades
		
		try {
			lista = ciudadDAO.obtener();
			for(Ciudad ciudad: lista){
				System.out.println(ciudad.getCodigo() + ": " + ciudad.getNombre());
			}
			assertTrue(lista.size()>0);
		} catch (MyException e) {
			// TODO: handle exception
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testObtenerLong() {
		Ciudad ciudad = null;//Objeto donde se almacenan la ciudad
		try {
			ciudad = ciudadDAO.obtener(2L);
			assertNotNull(ciudad);
			System.out.println(ciudad.getCodigo() + ": " + ciudad.getNombre());
		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testGuardar() {
		Ciudad ciudad = new Ciudad();		
		try{
			ciudad.setCodigo(1L);
			ciudad.setCodigoArea("09");
			ciudad.setNombre("Armenia");
			ciudadDAO.guardar(ciudad); 
			//assertTrue(ciudad != null);
		}catch (MyException e) {
				e.printStackTrace();
				fail(e.getMessage());
		}
	}

}
