//Implementacion de los metodos para accerder a los datos de la BD
package co.edu.udea.iw.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;
/**
 * 
 * @author Juan Diego - diego.goez@udea.edu.co
 * @version 2.0
 */
public class CiudadDAOImp implements CiudadDAO{
	
	//Implementacion del metodo para obtener todas las ciudades
	public List<Ciudad> obtener() throws MyException{
		Connection con = null;// para la conexion con la base de datos
		PreparedStatement ps = null;// para crear la consulta sql
		ResultSet rs = null;// para  capturar los datos que devuelve la consulta
		List<Ciudad> lista = new ArrayList<Ciudad>();//List para almacenar las ciudades
		DataSource ds = DataSource.getInstance();
		try {
			con = ds.getConnection();			
			ps = con.prepareStatement("SELECT * FROM ciudades");//Consulta a la BD
			rs = ps.executeQuery();//Ejecucion y captura del resultado
			while (rs.next()) {//Ciclo para procesar los datos
				Ciudad ciudad = new Ciudad();
				ciudad.setCodigo(rs.getLong("codigo"));
				ciudad.setNombre(rs.getString("Nombre"));
				ciudad.setCodigoArea(rs.getString("codigoArea"));
				lista.add(ciudad);
			}
		} catch (SQLException e) {//No existe la BD
			throw new MyException("Error consultando", e);
		} finally {
			try {
				//Cierre de conexion con la BD
				if (rs != null) 
					rs.close();
				
				if (ps != null) 
					ps.close();
				
				if (con != null) 
					con.close();				
			} catch (SQLException e) {
				throw new MyException("Error cerrando", e);
			}
		}
		return lista;
	}
	
	//Implementacion del metodo para obtener una ciudad
	public Ciudad obtener(Long codigo) throws MyException{
		Connection con = null;// para la conexion con la base de datos
		PreparedStatement ps = null;// para crear la consulta sql
		ResultSet rs = null;// para  capturar los datos que devuelve la consulta
		Ciudad ciudad = null;//Objeto para almacenar la ciudad
		DataSource ds = DataSource.getInstance();
		try {
			con = ds.getConnection();//Conexion con la BD			
			ps = con.prepareStatement("SELECT * FROM ciudades WHERE codigo = ?");//Consulta a la BD
			ps.setLong(1, codigo);//
			rs = ps.executeQuery();//Ejecucion y captura del resultado
			if(rs.next()){
				//Procesamiento de la ciudad
				ciudad = new Ciudad();
				ciudad.setCodigo(rs.getLong("codigo"));
				ciudad.setNombre(rs.getString("nombre"));
				ciudad.setCodigoArea(rs.getString("codigoArea"));
			}
		} catch (SQLException e) {//No existe la BD
			throw new MyException("Error consultando", e);
		} finally {
			try {
				//Cierre de conexion con la BD
				if (rs != null) 
					rs.close();
				
				if (ps != null) 
					ps.close();
				
				if (con != null) 
					con.close();				
			} catch (SQLException e) {
				throw new MyException("Error cerrando", e);
			}
		}
		return ciudad;
	}
	
}
