package testeBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

public class ConnectionFactory {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/banco";
	private static final String USER = "root";
	private static final String PASS = "root";
	
	public static Connection getConnection() {
		
			try {
				Class.forName(DRIVER);
				return DriverManager.getConnection(URL, USER, PASS);
				
			} catch (ClassNotFoundException | SQLException e) {
				throw new RuntimeErrorException("Erro na conexão",e);
			}
		
	}

}
