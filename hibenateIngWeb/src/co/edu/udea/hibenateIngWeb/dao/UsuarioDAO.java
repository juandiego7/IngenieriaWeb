package co.edu.udea.hibenateIngWeb.dao;

import co.edu.udea.hibenateIngWeb.dto.Usuario;
import co.edu.udea.hibernateIngWeb.exception.MyException;
/**
 * 
 * @author Juan Diego - diego.goez@udea.edu.co
 * @version 3.0
 *
 */
public interface UsuarioDAO {
	//metodo para obtener un usuario
	public Usuario obtener(String login) throws MyException;
}
