package co.edu.udea.spring.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.udea.spring.dto.Usuario;
import co.edu.udea.spring.exception.MyException;
/**
 * 
 * @author Juan Diego - diego.goez@udea.edu.co
 * @version 3.0
 *
 */
public class UsuarioDAOImpl implements UsuarioDAO{
	
	SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Usuario obtener(String login) throws MyException {
		Usuario usuario = new Usuario();
		Session session = null;
		try{
			session = sessionFactory.getCurrentSession();
			usuario = (Usuario) session.get(Usuario.class,login);
		}catch (HibernateException e) {
			throw new MyException("Error consultando usuario", e);
		}
		return usuario;
	}

}
