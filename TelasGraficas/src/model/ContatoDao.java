package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controler.ConnectionFactory;

public class ContatoDao {

	private Connection connection;

	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
		System.out.printf("Conectado no banco.\n");
	}

	public void adicionar(Contato contato) {

		String sql = "insert into contatos" + "(email,nome,idade)" + "values(?,?,?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			

			stmt.setString(1, contato.getEmail());
			stmt.setString(2, contato.getNome());
			stmt.setInt(3, contato.getIdade());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void busca() {
		try {
			// comando sql para buscar todos os dados na tabela contatos.
			PreparedStatement stmt = connection.prepareStatement("select * from contatos");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// captura o email retornado no resultSet
				String email = rs.getString("email");
				// captura o nome retornado no resultSet
				String nome = rs.getString("nome");
				// captura a idade retornado no resultSet
				int idade = rs.getInt("idade");

				System.out.println("Nome: " + nome + "   Email: " + email + "Idade: " + idade);
			}

			stmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	public List<Contato> getLista() {

		try {
			List<Contato> contatos = new ArrayList<Contato>();

			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				// criando o objeto contato
				Contato contato = new Contato();

				contato.setId(rs.getLong("id"));
				contato.setEmail(rs.getString("email"));
				contato.setNome(rs.getString("nome"));
				contato.setIdade(rs.getInt("idade"));

				// adicionando o contato a lista
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			return contatos;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
