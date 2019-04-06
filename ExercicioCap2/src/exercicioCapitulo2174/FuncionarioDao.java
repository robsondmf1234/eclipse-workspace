package exercicioCapitulo2174;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao {

	private Connection connection;

	public FuncionarioDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Funcionario funcionario) {
		String sql = "insert into funcionarios" + "(nome,usuario,senha)" + "values(?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());

			System.out.println("Funcionario adicionado com sucesso.");
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public void altera(Funcionario funcionario) {
		String sql = "update funcionarios set nome=?,usuario=?," + "senha=? where id=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			stmt.setLong(4, funcionario.getId());

			System.out.println("Funcionário alterado com sucesso.");
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void busca() {
		String sql = "select * from funcionarios";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String nome = rs.getString("nome");
				String usuario = rs.getString("usuario");
				String senha = rs.getString("senha");

				System.out.println("Nome: " + nome);
				System.out.println("Usuario: " + usuario);
				System.out.println("Senha: " + senha);

				rs.close();
				stmt.close();
			}
		} catch (Exception e) {
			// Exception
		}
	}

	public List<Funcionario> buscaLista() {
		String sql = "select * from funcionarios";

		try {
			List<Funcionario> funcionarios = new ArrayList<Funcionario>();
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setNome(rs.getString("nome"));
				funcionario.setUsuario(rs.getString("usuario"));
				funcionario.setSenha(rs.getString("senha"));

				funcionarios.add(funcionario);
			}
			stmt.close();
			rs.close();
			return funcionarios;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(Funcionario funcionario) {
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement("delete from funcionarios where id=?");
			
			stmt.setLong(1, funcionario.getId());
			
			stmt.execute();
			System.out.println("Funcionario removido com sucesso");
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
