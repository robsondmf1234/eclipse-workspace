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

		String sql = "insert into usuarios" + "(nome,email,unidade,telefone,telefoneAlter,cep)" + "values(?,?,?,?,?,?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getUnidade());
			stmt.setString(4, contato.getTelefone());
			stmt.setString(5, contato.getTelefoneAlter());
			stmt.setString(6, contato.getCep());
			
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
				// captura o nome retornado no resultSet
				String nome = rs.getString("nome");
				// captura a senha no resultSet
				int senha = rs.getInt("senha");
			
				System.out.println("Nome: " + nome + "   Senha: " + senha);
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
				contato.setNome(rs.getString("nome"));
				
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
