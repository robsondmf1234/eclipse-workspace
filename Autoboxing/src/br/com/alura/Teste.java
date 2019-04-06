//Aula 6.01
//Demonstrando o uso do autoboxing para valores primitivos de int >>>> Integer
package br.com.alura;

import java.util.ArrayList;
import java.util.List;

public class Teste {

	public static void main(String[] args) {

		int[] idades = new int[5];

		String[] nomes = new String[5];

		// System.out.println(Integer.SIZE);

		int idade = 29; // Integer ,Java faz automaticamente
		int idade2 = 0;

		Integer idadeRef = Integer.valueOf(29);
		System.out.println(idadeRef);

		idade2 = idadeRef.intValue();
		System.out.println(idade2);

		String idade4 = "31";

		int idade3 = Integer.parseInt(idade4);
		System.out.println(idade3);
		// String s = args[0];
		// System.out.println(s);

		// Lista onde o Java converte o valor automaticamente para um Integer ,pois a
		// lista só utilizar Integer
		// List numeros = new ArrayList();

		// Lista ja especificando o Integer
		List<Integer> numeros = new ArrayList<Integer>();
		numeros.add(idade); // Autoboxing

	}

}
