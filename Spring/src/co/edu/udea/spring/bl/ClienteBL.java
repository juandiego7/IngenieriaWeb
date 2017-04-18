package co.edu.udea.spring.bl;

import java.util.List;

import org.hibernate.SessionFactory;

import co.edu.udea.spring.dao.ClienteDAO;
import co.edu.udea.spring.dao.UsuarioDAO;
import co.edu.udea.spring.dto.Cliente;
import co.edu.udea.spring.exception.MyException;

public class ClienteBL {
	
	private ClienteDAO clienteDAO;
	private UsuarioDAO usuarioDAO;
	
	public List<Cliente> obtener() throws MyException{
		return clienteDAO.obtener();
	}
	
	public void guardar(String cedula, String nombres, String apellidos, String email, String usuarioCrea)
			throws MyException{
		if (cedula == null || "".equals(cedula)) {
			throw new MyException("La cedula no puede estar vacia");
		}
		if (nombres == null || "".equals(nombres)) {
			throw new MyException("La cedula no puede estar vacia");
		}
		if (apellidos == null || "".equals(apellidos)) {
			throw new MyException("La cedula no puede estar vacia");
		}
		if (email == null || "".equals(email)) {
			throw new MyException("La cedula no puede estar vacia");
		}
		if (usuarioCrea == null || "".equals(usuarioCrea)) {
			throw new MyException("La cedula no puede estar vacia");
		}
	}

	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
}
