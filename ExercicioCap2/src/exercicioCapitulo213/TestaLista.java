package exercicioCapitulo213;

import java.util.Calendar;
import java.util.List;

//Programa que demonstra a inserção de dados , busca de dados retornando uma lista de contatos

public class TestaLista {

	public static void main(String[] args) {

		Contato contato = new Contato();

		contato.setNome("TesteExercicio");
		contato.setEmail("xxx@gmail.com");
		contato.setEndereco("Rua: xxx");
		contato.setDataNascimento(Calendar.getInstance());

		ContatoDao dao = new ContatoDao();

		dao.adicionar(contato);
		System.out.println("Contato adicionado.");

		List<Contato> contatos = dao.getLista();

		for (Contato contato1 : contatos) {
			System.out.println("Nome: " + contato1.getNome());
			System.out.println("Email: " + contato1.getEmail());
			System.out.println("Endereço: " + contato1.getEndereco());
			System.out.println("Data de Nascimento: " + contato1.getDataNascimento().getTime() + "\n");
		}
	}

}
