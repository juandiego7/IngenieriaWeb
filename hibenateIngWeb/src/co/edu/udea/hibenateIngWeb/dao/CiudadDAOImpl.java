//Clase para 
package co.edu.udea.hibenateIngWeb.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import co.edu.udea.hibenateIngWeb.dto.Ciudad;
import co.edu.udea.hibernateIngWeb.exception.MyException;

/**
 * 
 * @author Juan Diego - diego.goez@udea.edu.co
 * @version 2.0
 *
 */

public class CiudadDAOImpl implements CiudadDAO{

	@Override
	public List<Ciudad> obtener() throws MyException {
		List<Ciudad> lista = new ArrayList<Ciudad>();
		Session session = null;
		try {
			session = DataSource.getInstancia().getSession();
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
			session = DataSource.getInstancia().getSession();
			ciudad = (Ciudad) session.get(Ciudad.class,codigo);
		}catch (HibernateException e) {
			throw new MyException("Error consultando ciudad", e);
		}
		return ciudad;
	}

	@Override
	public void guardar(Ciudad ciudad) throws MyException {
		Transaction tx = null;
		Session session = null;
		try {
			session = DataSource.getInstancia().getSession();
			tx = session.beginTransaction();
			session.save(ciudad);
			tx.commit();
		} catch (HibernateException e) {
			throw new MyException("Error guardando ciudad", e);
		}
	}

}
