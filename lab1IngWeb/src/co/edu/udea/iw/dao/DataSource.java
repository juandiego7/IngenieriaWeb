//Clase para acceder a la base de datos
package co.edu.udea.iw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import co.edu.udea.iw.exception.MyException;

/**
 * 
 * @author Juan Diego
 * @version 1.0
 *
 */
public class DataSource {
	
	private static DataSource dataSource;
	
	private DataSource(){
		
	}
	
	public static DataSource getInstance(){
		if(dataSource != null){
			return dataSource;
		}
		return new DataSource();
	}
	
	public Connection getConnection() throws MyException{
		Connection con = null;// para la conexion con la base de datos
		PreparedStatement ps = null;// para crear la consulta sql
		ResultSet rs = null;// para  capturar los datos que devuelve la consulta
		try {
			Class.forName("com.mysql.jdbc.Driver");//Cargar driver de mysql
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labIngWeb","root","root");			
			ps = con.prepareStatement("SELECT * FROM ciudades");
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("codigo")+": "+rs.getString("Nombre"));
			}
		} catch (ClassNotFoundException e) {//No existe el driver de mysql
			throw new MyException("Driver no encontrado", e);
		} catch (SQLException e) {//No existe la BD
			throw new MyException("No puede establecer conexion", e);
		}
		return con;
	}
}
