package Teste3;

public class TesteLivro {

	public static void main(String[] args) {

		String nome = "Java EE";
		String autor = "Alberto Souza";
		String descricao = "A especificação Java EE e suas respectivas "
				+ "implementações vêm evoluindo ao longo do tempo. " + "A configuração e utilização das especificações "
				+ "ficaram bem mais fáceis. O que ainda não é " + "tão fácil de enxergar é como podemos colocá-las "
				+ "para trabalhar em conjunto. Quais eu devo usar "
				+ "no meu próximo projeto? O que realmente eu posso "
				+ "fazer com cada uma delas? Como fazer com que uma " + "converse com a outra?";

		Livro livro = new Livro(nome, autor, descricao);

		//Imprimindo 
		System.out.println(livro);
		
//		System.out.println(livro.getNome());
//		System.out.println(livro.getAutor());
//		System.out.println(livro.getDescricao());
	}

}
