package Exercicio28;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class JDBCInsere {
	public static void main(String[] args) throws SQLException {
		Connection con = null;
		try {
			// conectando
			con = new ConnectionFactory().getConnection();

			// cria um preparedStatement
			String sql = "insert into contatos" + 
			"(nome,email,endereco,dataNascimento)" + 
			"values(?,?,?,?)";

			PreparedStatement stmt = con.prepareStatement(sql);

			// prenche os valores
			stmt.setString(1, "Caelum");
			stmt.setString(2, "contato@caelum.com.br");
			stmt.setString(3, "R,Vergueiro 3185 cj57");
			// pega a data atual
			stmt.setDate(4, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));

			// executa
			stmt.execute();
			stmt.close();

			System.out.println("Gravado");

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// fecha conexao
			con.close();

		}

	}
}