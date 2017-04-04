package co.edu.udea.hibernateIngWeb.dao.impl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import co.edu.udea.hibenateIngWeb.dao.ClienteDAO;
import co.edu.udea.hibenateIngWeb.dao.ClienteDAOImpl;
import co.edu.udea.hibenateIngWeb.dto.Cliente;
import co.edu.udea.hibenateIngWeb.dto.Usuario;
import co.edu.udea.hibernateIngWeb.exception.MyException;

public class ClienteDAOImplTest {

	@Test
	public void testObtenerClientes() {
		ClienteDAO clienteDAO = null;
		List<Cliente> resultado = null;
		try{
			clienteDAO = new ClienteDAOImpl();
			resultado = clienteDAO.obtener();
			assertTrue(resultado.size() > 0);
		}catch (MyException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void guardarCliente(){
		ClienteDAO clienteDAO = null; 
		Cliente cliente = null; 
		Usuario usuario = null;
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
			
			clienteDAO = new ClienteDAOImpl();
			clienteDAO.guardar(cliente); 
			assertTrue(cliente != null);
		}catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
