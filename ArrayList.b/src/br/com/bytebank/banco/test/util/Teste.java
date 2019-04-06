
//Aula 3.09
//Exemplo de uso de ArrayList com Generics

package br.com.bytebank.banco.test.util;

import java.util.ArrayList;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class Teste {

	public static void main(String[] args) {
		
		//Declarnado ArrayList com Generics
		ArrayList<Conta> lista = new ArrayList<Conta>();

		Conta cc = new ContaCorrente(22, 11);
		lista.add(cc);

		Conta cc2 = new ContaCorrente(22, 22);
		lista.add(cc2);

		System.out.println("Tamanho: " + lista.size());
		Conta ref =  lista.get(0);
		System.out.println(ref.getNumero());

		lista.remove(0);

		System.out.println("Tamanho: " + lista.size());

		Conta cc3 = new ContaCorrente(33, 11);
		lista.add(cc3);

		Conta cc4 = new ContaCorrente(44, 22);
		lista.add(cc4);
		
		//Iterando sobre a lista 
		for (Conta conta : lista) {
			System.out.println(conta);
		}

	}

}
