package co.edu.udea.spring.dao;

import co.edu.udea.spring.dto.Usuario;
import co.edu.udea.spring.exception.MyException;
/**
* Interface para definir los metodos para los usuarios
 * @author Juan Diego - diego.goez@udea.edu.co
 * @version 1.0
 *
 */
public interface UsuarioDAO {
	//metodo para obtener un usuario
	public Usuario obtener(String login) throws MyException;
}
	