package br.com.projeto.Set.exercicios;

import java.util.*;

public class TesteAlunosSemAcentos {

	public static void main(String[] args) {

		Set<String> alunos = new HashSet<>();

		// 1) adicione alguns alunos
		alunos.add("Aluno1");
		alunos.add("Aluno2");
		alunos.add("Aluno3");
		// 2) imprima o tamanho da colecao
		System.out.println("Tamanho do Set - " + alunos.size());
		// 3) tente adicionar um aluno que existe
		alunos.add("Aluno1");
		// 4) imprima novamente o tamanho da colecao
		System.out.println("Tamanho do Set - " + alunos.size());
		
	}
}