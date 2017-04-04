package co.edu.udea.hibenateIngWeb.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import co.edu.udea.hibenateIngWeb.dto.Cliente;
import co.edu.udea.hibernateIngWeb.exception.MyException;

public class ClienteDAOImpl implements ClienteDAO{

	@Override
	public List<Cliente> obtener() throws MyException {
		List<Cliente> clientes = new ArrayList<Cliente>();
		Session session = null;
		Criteria criteria = null;
		try{
			session = DataSource.getInstancia().getSession();
			criteria = session.createCriteria(Cliente.class);
			criteria.addOrder(Order.asc("fechaCreacion"));
			//SELECT * Clientes Order by FechaCreacion asc
			clientes = criteria.list();
		}catch (HibernateException e) {
			throw new MyException("Error consultando cliente", e);
		}
		return clientes;
	}
	@Override
	public void guardar(Cliente cliente) throws MyException {
		Transaction tx = null;
		Session session = null;
		try{
			session = DataSource.getInstancia().getSession();
			tx = session.beginTransaction();
			session.save(cliente);
			tx.commit();
		}catch (HibernateException e) {
			throw new MyException("Error guardando cliente", e);
		}
	}


}
