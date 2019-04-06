package exercicioCapitulo216;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.management.RuntimeErrorException;

public class ContatoDao {

	private Connection connection;

	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adicionar(Contato contato) {

		String sql = "insert into contatos" + "(nome,email,endereco,dataNascimento)" + "values(?,?,?,?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			System.out.println("Contato adicionado.");
			
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<Contato> getLista() {

		try {
			List<Contato> contatos = new ArrayList<Contato>();

			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				Contato contato = new Contato();

				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);

				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			return contatos;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Contato contato) {
		String sql = "update contatos set nome=?, email=?," + "endereco=?, dataNascimento=? where id=?";

		try {

			PreparedStatement stmt = this.connection.prepareStatement(sql);

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			
			System.out.println("Contato alterado com sucesso.");
			
			stmt.execute();
			stmt.close();

		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public void remove(Contato contato) {

		try {
			PreparedStatement stmt = this.connection.prepareStatement("delete from contatos where id=?");

			stmt.setLong(1, contato.getId());
			System.out.println("Contato removido com sucesso.");
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
