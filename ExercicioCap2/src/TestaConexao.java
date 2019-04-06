import java.sql.SQLException;
import java.util.Calendar;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {

		// pronto para gravar
		Contato contato = new Contato();
		contato.setNome("Robson");
		contato.setEmail("xxxxxx@caelum.com.br");
		contato.setEndereco("R. Vergueiro 3185 cj57");
		contato.setDataNascimento(Calendar.getInstance());
		
		// grave nessa conex�o!!!
		ContatoDao dao = new ContatoDao();
		
		// m�todo elegante
		dao.adiciona(contato);
		
		System.out.println("Gravado!");
	}
}
