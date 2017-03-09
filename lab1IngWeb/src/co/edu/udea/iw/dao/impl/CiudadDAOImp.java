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
 * @author Juan Diego
 * @version 1.0
 */
public class CiudadDAOImp implements CiudadDAO{
	
	//Metodo para obtener todas las ciudades de la BD
	public List<Ciudad> obtener() throws MyException{
		Connection con = null;// para la conexion con la base de datos
		PreparedStatement ps = null;// para crear la consulta sql
		ResultSet rs = null;// para  capturar los datos que devuelve la consulta
		List<Ciudad> lista = new ArrayList<Ciudad>();//List para almacenar las ciudades
		try {
			con = DataSource.getConnection();			
			ps = con.prepareStatement("SELECT * FROM ciudades");
			rs = ps.executeQuery();
			while (rs.next()) {
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
}
