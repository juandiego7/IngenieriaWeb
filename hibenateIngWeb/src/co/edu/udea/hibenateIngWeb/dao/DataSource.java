//Clase para acceder a la base de datos con el patron Singleton
package co.edu.udea.hibenateIngWeb.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import co.edu.udea.hibernateIngWeb.exception.MyException;

/**
 * 
 * @author Juan Diego - diego.goez@udea.edu.co
 * @version 1.1
 *
 */
public class DataSource {
	private static DataSource instancia;//Singleton
	private SessionFactory factory = null;
	private Configuration conf = new Configuration();
	
	//constructor privado para el Singleton
	private DataSource(){
		
	}
	
	public static DataSource getInstancia(){
		if(instancia==null)
			instancia = new DataSource();
		return instancia;
	}
	
	public Session getSession() throws MyException{
		try{
			if(factory==null){
				conf.configure("co/edu/udea/hibernateIngWeb/config/hibernate.cfg.xml");
				factory = conf.buildSessionFactory();
			}	
		}catch (HibernateException e) {
			throw new MyException("Error configurando la session",e);
		}
		return factory.openSession();
	}
}
