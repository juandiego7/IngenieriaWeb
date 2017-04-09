package co.edu.udea.hibernateIngWeb.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import co.edu.udea.hibenateIngWeb.dao.UsuarioDAO;
import co.edu.udea.hibenateIngWeb.dao.UsuarioDAOImpl;
import co.edu.udea.hibenateIngWeb.dto.Usuario;
import co.edu.udea.hibernateIngWeb.exception.MyException;
/**
 * 
 * @author Juan Diego - diego.goez@udea.edu.co
 * @version 3.0
 *
 */
public class UsuarioDAOImplTest {

	//Prueba para obtener un usuario
	@Test
	public void testObtener() {
		UsuarioDAO usuarioDAO = null;//Declaracion de interfaz para implementar los metodos con la BD
		Usuario usuario = null;//Objeto donde se almacenan el usuario
		
		try {
			usuarioDAO = new UsuarioDAOImpl();
			usuario = usuarioDAO.obtener("juan");
			assertTrue(usuario != null);
			System.out.println(usuario.getRol().getNombre());//Rol del usuario
		} catch (MyException e) {
			// TODO: handle exception
			fail(e.getMessage());
		}
	}

}
