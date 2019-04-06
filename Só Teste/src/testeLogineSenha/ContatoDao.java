package testeLogineSenha;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoDao {

	private Connection connection;

	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
		System.out.printf("Conectado no banco.\n");
	}

	public void adicionar(Contato contato) {

		String sql = "insert into usuarios" + "(login,senha,nome,email)" + "values(?,?,?,?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, contato.getLogin());
			stmt.setString(2, contato.getSenha());
			stmt.setString(3, contato.getNome());
			stmt.setString(4, contato.getEmail());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void busca() {
		try {
			// comando sql para buscar todos os dados na tabela contatos.
			PreparedStatement stmt = connection.prepareStatement("select * from usuarios ");
			// PreparedStatement stmt = connection.prepareStatement("select * from usuarios
			// where login = ? and senha = ?");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// captura o nome retornado no resultSet
				String login = rs.getString("login");
				// captura a senha no resultSet
				String senha = rs.getString("senha");
				String nome = rs.getString("nome");
				String email = rs.getString("email");

				System.out
						.println("Login: " + login + "  Senha:  " + senha + "  Nome:  " + nome + "  Email:  " + email);
			}

			stmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	public Contato buscaRefinada(Contato contato) {
		try {
			Contato contatoRetorno = null;
			// comando sql para buscar todos os dados na tabela contatos.
			PreparedStatement stmt = connection
					.prepareStatement("select * from usuarios where login = ? and senha = ?");
			

			stmt.setString(1, contato.getLogin());
			stmt.setString(2, contato.getSenha());
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				// captura o nome retornado no resultSet
				contatoRetorno = new Contato();
				contatoRetorno.setLogin(rs.getString("login"));
				contatoRetorno.setNome(rs.getString("nome"));
				contatoRetorno.setEmail(rs.getString("email"));
			}

			
			stmt.close();
			rs.close();
			return contatoRetorno;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	public List<Contato> getLista() {

		try {
			List<Contato> contatos = new ArrayList<Contato>();

			PreparedStatement stmt = this.connection.prepareStatement("select * from usuarios");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				// criando o objeto contato
				Contato contato = new Contato();

				contato.setId(rs.getLong("id"));
				contato.setLogin(rs.getString("login"));
				contato.setSenha(rs.getString("senha"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));

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
