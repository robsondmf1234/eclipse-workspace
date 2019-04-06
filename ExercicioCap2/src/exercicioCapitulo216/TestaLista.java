package exercicioCapitulo216;

import java.util.Calendar;
import java.util.List;

//Programa que demonstra a inserção de dados , busca de dados retornando uma lista de contatos

public class TestaLista {

	public static void main(String[] args) {

		Contato contato = new Contato();
		
		contato.setNome("Alterado3");
		contato.setEmail("alterado3@gmail.com");
		contato.setEndereco("Rua: alterado3");
		contato.setDataNascimento(Calendar.getInstance());
		//contato.setId(28l);

		ContatoDao dao = new ContatoDao();

		//método para adicionar um contato
		dao.adicionar(contato);
		
		//método para alterar um contato
		//dao.altera(contato);
		
		// método para remover um contato
		//dao.remove(contato);

		//List<Contato> contatos = dao.getLista();

		/*for (Contato contato1 : contatos) {
			System.out.println("Id:"+contato1.getId());
			System.out.println("Nome: " + contato1.getNome());
			System.out.println("Email: " + contato1.getEmail());
			System.out.println("Endereço: " + contato1.getEndereco());
			System.out.println("Data de Nascimento: " + contato1.getDataNascimento().getTime() + "\n");
		}*/
	}

}
