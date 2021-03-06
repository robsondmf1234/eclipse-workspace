

//Aula 4.01
//Exemplo de uso de ArrayList com Generics
//Exemplo do uso de equals ,para verificar se a lista ja possui um objeto igual ao passado como parametro no m�todo contains.

package br.com.bytebank.banco.test.util;

import java.util.ArrayList;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteArrayList {

	public static void main(String[] args) {
		
		//Declarnado ArrayList com Generics
		ArrayList<Conta> lista = new ArrayList<Conta>();

		Conta cc = new ContaCorrente(22, 11);
		lista.add(cc);

		Conta cc2 = new ContaCorrente(22, 22);
		lista.add(cc2);

		Conta cc3 = new ContaCorrente(22, 22);
		
		boolean existe = lista.contains(cc3);
		System.out.println("J� existe ? "+existe);
		
		
		//Iterando sobre a lista 
		for (Conta conta : lista) {
			System.out.println(conta);
		}

	}

}
