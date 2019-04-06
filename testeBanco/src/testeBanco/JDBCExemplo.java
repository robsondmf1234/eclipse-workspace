package testeBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCExemplo {

	public static void main(String[] args) throws SQLException {

		Connection conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1/banco","root","root");
		System.out.println("Conectado");
		conexao.close();

	}

}
