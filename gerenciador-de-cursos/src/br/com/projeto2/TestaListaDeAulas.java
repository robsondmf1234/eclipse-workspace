//Aula sobre collections e seus métodos

package br.com.projeto2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestaListaDeAulas {

	public static void main(String[] args) {

		Aula a1 = new Aula("Revisitando arrayList", 22);
		Aula a2 = new Aula("Trabalhando com lista de objetos", 13);
		Aula a3 = new Aula("Relacionamento de listas e objetos", 15);

		ArrayList<Aula> aulas = new ArrayList<>();
		aulas.add(a1);
		aulas.add(a2);
		aulas.add(a3);
		
		System.out.println(aulas);
		
		Collections.sort(aulas);
		
		System.out.println("Lista ordenada");
		
		System.out.println(aulas);
		
		
		Collections.sort(aulas, Comparator.comparing(Aula::getTempo));

		System.out.println("Lista ordenada por tempo");
		
		System.out.println(aulas);
		
	}

}
