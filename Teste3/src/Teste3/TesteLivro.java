package Teste3;

public class TesteLivro {

	public static void main(String[] args) {

		String nome = "Java EE";
		String autor = "Alberto Souza";
		String descricao = "A especifica��o Java EE e suas respectivas "
				+ "implementa��es v�m evoluindo ao longo do tempo. " + "A configura��o e utiliza��o das especifica��es "
				+ "ficaram bem mais f�ceis. O que ainda n�o � " + "t�o f�cil de enxergar � como podemos coloc�-las "
				+ "para trabalhar em conjunto. Quais eu devo usar "
				+ "no meu pr�ximo projeto? O que realmente eu posso "
				+ "fazer com cada uma delas? Como fazer com que uma " + "converse com a outra?";

		Livro livro = new Livro(nome, autor, descricao);

		//Imprimindo 
		System.out.println(livro);
		
//		System.out.println(livro.getNome());
//		System.out.println(livro.getAutor());
//		System.out.println(livro.getDescricao());
	}

}
