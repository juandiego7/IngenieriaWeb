/**
 * 
 */
package co.edu.udea.spring.dao.impl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.spring.dao.ClienteDAO;
import co.edu.udea.spring.dao.ClienteDAOImpl;
import co.edu.udea.spring.dto.Cliente;
import co.edu.udea.spring.dto.Direccion;
import co.edu.udea.spring.dto.Usuario;
import co.edu.udea.spring.exception.MyException;


/**
 * @author Juan Diego Goez - diego.goez@udea.edu.co
 * @version 2
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)//Correr con otro running
@Transactional//transaccional
@ContextConfiguration(locations="classpath:config.xml")//para saber donde esta el archivo de configuracion de spring para cargarlo
public class ClienteDAOImplTest {

	@Autowired//Inyectar datos desde la base de datos
	ClienteDAO clienteDAO;
	
	Logger logger = Logger.getLogger(MyException.class);
	
	/**
	 * Test method for {@link co.edu.udea.spring.dao.ClienteDAOImpl#obtener()}.
	 * @throws MyException 
	 */
	@Test
	public void testObtener(){
		List<Cliente> resultado = null;
		PropertyConfigurator.configure("src/log4j.properties");
		try{
			
			resultado = clienteDAO.obtener();
			for(Cliente c: resultado){
				System.out.println("Cliente: " + c.getNombres() +" Cedula: "+c.getCedula());
				Set<Direccion> dir = c.getDirecciones();
				for(Direccion d: dir){
					System.out.println("Nombre: "+ c.getNombres() + " Dirección: "+d.getDireccion());
				}
			}
			assertTrue(resultado.size() > 0);
		}catch (MyException e) {
			logger.log(Level.ERROR, e.getMessage());
		}
	}

	/**
	 * 
	 */
	@Test
	public void testGuardar() {
		Cliente cliente = null; 
		Usuario usuario = null;
		PropertyConfigurator.configure("src/log4j.properties");
		try{
			cliente = new Cliente();
			cliente.setCedula("333");
			cliente.setNombres("Melissa");
			cliente.setApellidos("Figueroa");
			cliente.setEmail("r@g.com");
			usuario = new Usuario();
			usuario.setLogin("elver");
			cliente.setUsuarioCrea(usuario);
			cliente.setFechaCreacion(new Date());
			
			clienteDAO.guardar(cliente); 
			assertTrue(cliente != null);
		}catch (MyException e) {
			logger.log(Level.ERROR, e.getMessage());
		}
	}

}
