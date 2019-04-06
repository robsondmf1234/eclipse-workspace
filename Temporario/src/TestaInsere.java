import java.util.Calendar;
import java.util.List;

public class TestaInsere {

	public static void main(String[] args) {

		Contato contato = new Contato();
		contato.setNome("Teste");
		contato.setEmail("Teste");
		contato.setEndereco("Teste");
		contato.setDataNascimento(Calendar.getInstance());

		ContatoDao dao = new ContatoDao();
		// chama o método para adicionar contato
		dao.adiciona(contato);
		// chamando o método de busca
		dao.busca();
		
		//retorna a lista com objetos Contatos através do método dao.getLista(), para a lista contatos 
		List<Contato> contatos = dao.getLista();

		for (Contato contato1 : contatos) {
			System.out.println("Nome: " + contato1.getNome());
			System.out.println("Email: " + contato1.getEmail());
			System.out.println("Endereço: " + contato1.getEndereco());
			System.out.println("Data de Nascimento: " + contato1.getDataNascimento().getTime() + "\n");
		}

		System.out.println("Teste executado com sucesso!");
	}

}
