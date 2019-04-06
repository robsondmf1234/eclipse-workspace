//Aula sobre collections e seus métodos

package br.com.projeto;

import java.util.ArrayList;
import java.util.Collections;

public class TestandoListas {

	public static void main(String[] args) {

		String aula1 = "Conhecendo mais de Listas";
		String aula2 = "Modelando a classe Aula";
		String aula3 = "Trabalhando com cursos e Sets";
		String aula4 = "Aprendendo sobre Arrays";

		ArrayList<String> aulas = new ArrayList<>();
		aulas.add(aula1);
		aulas.add(aula2);
		aulas.add(aula3);
		aulas.add(aula4);

		System.out.println(aulas);

		for (String nomeAula : aulas) {
			System.out.println(nomeAula);
		}
		
		Collections.sort(aulas);
		
		System.out.println("\nListas ordenadas");
		for (String nomeAula : aulas) {
			System.out.println(nomeAula);
		}

	}

}
