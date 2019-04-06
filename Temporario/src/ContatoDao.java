import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ContatoDao {

	private Connection connection;

	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
		System.out.printf("Conectado no banco.\n");
	}

	public void adiciona(Contato contato) {

		String sql = "insert into contatos" +
		"(nome,email,endereco,dataNascimento)" + 
				"values(?,?,?,?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));

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
				// captura o email retornado no resultSet
				String email = rs.getString("email");

				System.out.println("Nome: " + nome + "   Email: " + email);
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
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				// montando a data atrvés do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);

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
