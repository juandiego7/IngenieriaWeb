package co.edu.udea.spring.dao.impl;

import static org.junit.Assert.*;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
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
 * Pruebas de los metodos de UsuarioDAO
 * @author Juan Diego Goez - diego.goez@udea.edu.co
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)//Correr con otro running
@Transactional//transaccional
@ContextConfiguration(locations="classpath:config.xml")//para saber donde esta el archivo de configuracion de spring para cargarlo
public class UsuarioDAOImplTest {

	@Autowired//Inyectar datos desde la base de datos
	UsuarioDAO usuarioDAO;
	
	Logger logger = Logger.getLogger(MyException.class);//Para manejar los errores
	
	/**
	 * Test method for {@link co.edu.udea.spring.dao.UsuarioDAOImpl#obtener(java.lang.String)}.
	 * Prueba de obtener(String login)
	 */
	@Test
	public void testObtener() {
		PropertyConfigurator.configure("src/log4j.properties");//propiedades para configurar log4j
		Usuario usuario = null; //Defino el objeto para almacenar el Usuario
		try{
			usuario = usuarioDAO.obtener("elver"); 
			System.out.println("Usuario: "+usuario.getNombres()+" Nombre del Rol: "+usuario.getRol().getNombre());
			assertTrue(usuario != null);		
		}catch (MyException e) {
			logger.log(Level.ERROR,"Error consultando: "+ e.getMessage());
		}
	}

}
