package co.edu.udea.hibenateIngWeb.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import co.edu.udea.hibenateIngWeb.dto.Usuario;
import co.edu.udea.hibernateIngWeb.exception.MyException;
/**
 * 
 * @author Juan Diego - diego.goez@udea.edu.co
 * @version 3.0
 *
 */
public class UsuarioDAOImpl implements UsuarioDAO{

	@Override
	public Usuario obtener(String login) throws MyException {
		Usuario usuario = new Usuario();
		Session session = null;
		try{
			session = DataSource.getInstancia().getSession();
			usuario = (Usuario) session.get(Usuario.class,login);
		}catch (HibernateException e) {
			throw new MyException("Error consultando usuario", e);
		}
		return usuario;
	}

}
