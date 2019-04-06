
//Programa que demonstra o uso de coleções
package br.com.projeto.Map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TesteCurso2 {

	public static void main(String[] args) {

		Curso javaColecoes = new Curso("Dominando as coleões Java", "Paulo Silveira");

		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
		javaColecoes.adiciona(new Aula("Modelando com coleções", 24));

		List<Aula> aulasImutaveis = javaColecoes.getAulas();
		System.out.println(aulasImutaveis);

		// Criando uma lista e passando como parametro a lista anterior,
		// será criada uma nova lista com todos os valores da lista passado como
		// parametro
		List<Aula> aulas = new ArrayList<>(aulasImutaveis);
		// Ordenando a lista
		Collections.sort(aulas);
		System.out.println(aulas);
		System.out.println(javaColecoes.getTempoTotal());
		System.out.println(javaColecoes);
	}

}
