package co.edu.udea.spring.bl;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.spring.dao.ClienteDAO;
import co.edu.udea.spring.dao.UsuarioDAO;
import co.edu.udea.spring.dto.Cliente;
import co.edu.udea.spring.dto.Usuario;
import co.edu.udea.spring.exception.MyException;
@Transactional
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
			throw new MyException("El nombre no puede estar vacio");
		}
		if (apellidos == null || "".equals(apellidos)) {
			throw new MyException("El apellido no puede estar vacia");
		}
		if (email == null || "".equals(email)) {
			throw new MyException("El email no puede estar vacia");
		}
		if (usuarioCrea == null || "".equals(usuarioCrea)) {
			throw new MyException("El usuarioCrea no puede estar vacia");
		}
		
		Usuario usuario = usuarioDAO.obtener(usuarioCrea);
		if (usuario == null) {
			throw new MyException("El usuario que crea no existe en la base de datos");
		}
		Cliente cliente = new Cliente();
		cliente.setCedula(cedula);
		cliente.setNombres(nombres);
		cliente.setApellidos(apellidos);
		cliente.setEmail(email);
		cliente.setUsuarioCrea(usuario);
		cliente.setFechaCreacion(new Date());
		cliente.setEliminado(Boolean.FALSE);
		
		clienteDAO.guardar(cliente);
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
