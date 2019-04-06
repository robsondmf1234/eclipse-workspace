//Programa que demonstrao uso de Set
package br.com.projeto.Set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestaAlunos {

	public static void main(String[] args) {

		Set<String> alunos = new HashSet<>();
		alunos.add("Robson Ferreira");
		alunos.add("Albert Eistein");
		alunos.add("Elon Musk");
		alunos.add("George Washigton");
		alunos.add("Alberto");
		alunos.add("Vicente");

		boolean elonStaMatriculado = alunos.contains("Elon Musk");
		System.out.println(elonStaMatriculado);

		// alunos.remove("Alberto");

		System.out.println(alunos.size());

		for (String aluno : alunos) {
			System.out.println(aluno);
		}
		System.out.println("\n");

		// Imprimindo com lambda
		alunos.forEach(aluno -> {
			System.out.println(aluno);
		});

		System.out.println(alunos);

		//Criando uma lista de alunos 
//		List<String> alunosEmLista = new ArrayList<>(alunos);
//		Collections.sort(alunosEmLista);
	}

}
