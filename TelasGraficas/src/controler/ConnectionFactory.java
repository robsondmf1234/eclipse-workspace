package controler;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	public Connection getConnection() {
		
		try {
			
			return DriverManager.getConnection("jdbc:mysql://localhost/usuarios", "root", "root");	
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
