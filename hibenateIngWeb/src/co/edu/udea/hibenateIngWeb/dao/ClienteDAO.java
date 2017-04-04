package co.edu.udea.hibenateIngWeb.dao;

import java.util.List;

import co.edu.udea.hibenateIngWeb.dto.Cliente;
import co.edu.udea.hibernateIngWeb.exception.MyException;

/**
 * Interface para definir los metodos del cliente en el sistema
 * @author Juan Diego Goez - diego.goez@udea.edu.co
 *
 */
public interface ClienteDAO {
	
	//metodo para obtener clientes
	public List<Cliente> obtener() throws MyException;
	
	public void guardar(Cliente cliente) throws MyException;
	
}
