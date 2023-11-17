package controlador;

import java.sql.*;

public class conexionDB {

	public Connection abrirBaseDatos() {
		
		String urlDB = "jdbc:mysql://localhost:3306/festividades";		
		String user = "userFestividades";
		String pw = "123456789";
		
		try {
			Connection accesoDB = DriverManager.getConnection(urlDB, user, pw);
			return accesoDB;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;			
		} 
		
	}
	
}
