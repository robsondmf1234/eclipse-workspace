package br.com.teste;

public class Principal {

	public static void main(String[] args) {

		System.out.println("Teste");
		System.out.println(formataDados("344/-+a,51.3.918-06"));

	}

	public static String formataDados(String dado) {
		return dado.replaceAll("[^0-9]+", "");
	}

}
