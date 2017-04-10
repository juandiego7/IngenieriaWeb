package co.edu.udea.spring.dao;

import java.util.List;

import co.edu.udea.spring.dto.Cliente;
import co.edu.udea.spring.exception.MyException;

/**
 * Interface para definir los metodos de los clientes
 * @author Juan Diego Goez - diego.goez@udea.edu.co
 * @version 1.0
 */
public interface ClienteDAO {
	
	//metodo para obtener clientes
	public List<Cliente> obtener() throws MyException;
	
	//Metodo para guardar un nuevo cliente
	public void guardar(Cliente cliente) throws MyException;
	
}
