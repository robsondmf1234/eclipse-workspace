import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Teste de conectividade com banco OK

public class Conexao {

	static String status = "";

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost/banco?user=root&password=root";
			conn = DriverManager.getConnection(url);

			status = "Connection opened";
		} catch (SQLException e) {
			status = e.getMessage();
		} catch (ClassNotFoundException e) {
			status = e.getMessage();
		} catch (Exception e) {
			status = e.getMessage();
		}
		return conn;
	}

}
