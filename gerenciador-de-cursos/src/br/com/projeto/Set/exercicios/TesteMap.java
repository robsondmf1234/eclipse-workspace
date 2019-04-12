package br.com.projeto.Set.exercicios;

import java.util.*;
import java.util.Map.Entry;

/**
 * @author Robson Douglas
 *
 *         11 de abr de 2019
 */

public class TesteMap {

	public static void main(String[] args) {

		Map<String, Integer> nomesParaIdade = new HashMap<>();
		nomesParaIdade.put("Paulo", 31);
		nomesParaIdade.put("Adriano", 25);
		nomesParaIdade.put("Alberto", 33);
		nomesParaIdade.put("Guilherme", 26);

		nomesParaIdade.keySet().forEach(idade -> {
			System.out.println("Idade: " + nomesParaIdade.get(idade));
		});
		System.out.println("\nMostrar nomes(Chave)");
		Set<String> chaves = nomesParaIdade.keySet();
		for (String nome : chaves) {
			System.out.println(nome);
		}

		System.out.println("\nMostrar Idades(Valor)");
		Collection<Integer> valores = nomesParaIdade.values();
		for (Integer idade : valores) {
			System.out.println(idade);
		}
		
		System.out.println("\nMostrar Chave e Valor.");	
		Set<Entry<String, Integer>> associacoes = nomesParaIdade.entrySet();    
		for (Entry<String, Integer> associacao : associacoes) {
		    System.out.println(associacao.getKey() + " - " + associacao.getValue());
		}
	}
}