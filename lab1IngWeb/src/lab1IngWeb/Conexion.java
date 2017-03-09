package lab1IngWeb;

/**
 * @author Juan Diego
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Conexion a base de datos mysql con jdbc
public class Conexion {
	
	public static void consultarCiudades() {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {//No existe la BD
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				//Close connection with BD
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		consultarCiudades();
	}

}
