/**
 * 
 */
package co.edu.udea.spring.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.spring.dao.UsuarioDAO;
import co.edu.udea.spring.dto.Usuario;
import co.edu.udea.spring.exception.MyException;

/**
 * @author Juan Diego
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)//Correr con otro running
@Transactional//transaccional
@ContextConfiguration(locations="classpath:config.xml")//para saber donde esta el archivo de configuracion de spring para cargarlo
public class UsuarioDAOImplTest {

	@Autowired//Inyectar datos desde la base de datos
	UsuarioDAO usuarioDAO;
	
	/**
	 * Test method for {@link co.edu.udea.spring.dao.UsuarioDAOImpl#obtener(java.lang.String)}.
	 */
	@Test
	public void testObtener() {
		Usuario usuario = null; //Defino el objeto para almacenar el Usuario
		try{
			usuario = usuarioDAO.obtener("elver"); //Consulto el Usuario
			System.out.println("Usuario: "+usuario.getNombres()+" Nombre del Rol: "+usuario.getRol().getNombre());
			assertTrue(usuario != null);//Verifico que la haya por lo menos un Usuario			
		}catch (MyException e) {
			e.printStackTrace();//Mostrar más información si ocurre un error, se debería mostar en un logger
			fail(e.getMessage());//Ha ocurrido un error consultando las ciudades
		}
	}

}
