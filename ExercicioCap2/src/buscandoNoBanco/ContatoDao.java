package buscandoNoBanco;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


//Comentar 

public class ContatoDao {

	private Connection connection;
	
	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Contato contato) {
		String sql = "insert into contatos " +
		"(nome,email,endereco,dataNascimento)" +
		" values (?,?,?,?)";

		try {
			// prepared statment para inser��o
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));

			// executa
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void busca() {
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String endereco = rs.getString("endereco");
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				//Date date = data.getTime();
				//System.out.println(sdf.format(data));
				
				//Convertendo a variavel Calendar para o formato (dia/m�s/ano)
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String nascimento = dateFormat.format(data.getTime());
				
				
				System.out.println("Nome: "+nome);
				System.out.println("Email: "+email);
				System.out.println("Endereco: "+endereco);	
				System.out.println("Data de Nascimento: "+nascimento);
						
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
