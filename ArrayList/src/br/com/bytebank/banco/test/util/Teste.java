
//Aula 3.0
//Exemplo de ArrayList

package br.com.bytebank.banco.test.util;

import java.util.ArrayList;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class Teste {

	public static void main(String[] args) {

		ArrayList lista = new ArrayList<>();

		Conta cc = new ContaCorrente(22, 11);
		lista.add(cc);

		Conta cc2 = new ContaCorrente(22, 22);
		lista.add(cc2);

		System.out.println("Tamanho: " + lista.size());
		Conta ref = (Conta) lista.get(0);
		System.out.println(ref.getNumero());

		lista.remove(0);

		System.out.println("Tamanho: " + lista.size());

		Conta cc3 = new ContaCorrente(33, 11);
		lista.add(cc3);

		Conta cc4 = new ContaCorrente(44, 22);
		lista.add(cc4);
		
		//Iterando sobre a lista 
		for (Object object : lista) {
			System.out.println(object);
		}

	}

}