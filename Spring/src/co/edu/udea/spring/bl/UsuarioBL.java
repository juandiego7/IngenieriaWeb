package co.edu.udea.spring.bl;

import co.edu.udea.spring.dao.UsuarioDAO;
import co.edu.udea.spring.dto.Usuario;
import co.edu.udea.spring.exception.MyException;

/**
 * Implementacion de la logica del negocio para el usuario
 * @author Juan Diego Goez Durango - diego.goez@udea.edu.co
 * @version 1.0
 */

public class UsuarioBL {
	private UsuarioDAO usuarioDAO;
	
	//Metodo que permite validar el usuario dado su login y contrasena
	public boolean validarUsuario(String login, String pws) throws MyException{
		if (login == null ||"".equals(login) ) {
			throw new MyException("El login del usuario no puede estar vacia");
		}
		if (pws == null ||"".equals(pws) ) {
			throw new MyException("La contrasena del usuario no puede estar vacia");
		}
		Usuario usuario = usuarioDAO.obtener(login);//Buscamos en la base de datos el usuario por su login
		if (usuario != null) {
			if (usuario.getContrasena() == pws) {
				return true;
			}			
		}
		return false;
	}

	/**
	 * @return the usuarioDAO
	 */
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	/**
	 * @param usuarioDAO the usuarioDAO to set
	 */
	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
	
}
