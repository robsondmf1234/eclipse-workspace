import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {

	public static void main(String[] args) throws SQLException {

		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/banco2", "root","root");
			System.out.println("Conectado");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
