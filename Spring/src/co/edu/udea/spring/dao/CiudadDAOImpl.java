//Clase para implementar los metodos de la interfaz CiudadDAO 
package co.edu.udea.spring.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import co.edu.udea.spring.dto.Ciudad;
import co.edu.udea.spring.exception.MyException;

/**
 * 
 * @author Juan Diego - diego.goez@udea.edu.co
 * @version 1.0
 *
 */

public class CiudadDAOImpl implements CiudadDAO{

	SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 
	 */
	@Override
	public List<Ciudad> obtener() throws MyException {
		List<Ciudad> lista = new ArrayList<Ciudad>();
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();//session provista por spring
			Criteria criteria = session.createCriteria(Ciudad.class);
			lista = criteria.list();
		} catch (HibernateException e) {
			throw new MyException("Error consultando ciudades",e);
		}
		return lista;
	}

	@Override
	public Ciudad obtener(Long codigo) throws MyException {
		Ciudad ciudad = new Ciudad();
		Session session = null;
		try{
			session = sessionFactory.getCurrentSession();
			ciudad = (Ciudad) session.get(Ciudad.class,codigo);
		}catch (HibernateException e) {
			throw new MyException("Error consultando ciudad", e);
		}
		return ciudad;
	}

	@Override
	public void guardar(Ciudad ciudad) throws MyException {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			session.save(ciudad);
		} catch (HibernateException e) {
			throw new MyException("Error guardando ciudad", e);
		}
	}

}
