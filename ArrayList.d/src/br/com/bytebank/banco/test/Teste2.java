//Aula 7.01
//Demonstrando o uso da ordernação com o método sort, implementando o Comparator
//Método sort , implementando o Comparator ,ordenando por getNumber
//Método sort , implementando o Comparator ,ordenando por nome de Titular
package br.com.bytebank.banco.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class Teste2 {

	public static void main(String[] args) {

		Conta cc1 = new ContaCorrente(22, 33);
		Cliente clienteCC1 = new Cliente();
		clienteCC1.setNome("Nico");
		cc1.setTitular(clienteCC1);
		cc1.deposita(333.0);

		Conta cc2 = new ContaPoupanca(22, 44);
		Cliente clienteCC2 = new Cliente();
		clienteCC2.setNome("Guilherme");
		cc2.setTitular(clienteCC2);
		cc2.deposita(444.0);

		Conta cc3 = new ContaCorrente(22, 11);
		Cliente clienteCC3 = new Cliente();
		clienteCC3.setNome("Paulo");
		cc3.setTitular(clienteCC3);
		cc3.deposita(111.0);

		Conta cc4 = new ContaPoupanca(22, 22);
		Cliente clienteCC4 = new Cliente();
		clienteCC4.setNome("Ana");
		cc4.setTitular(clienteCC4);
		cc4.deposita(222.0);

		List<Conta> lista = new ArrayList<>();
		lista.add(cc1);
		lista.add(cc2);
		lista.add(cc3);
		lista.add(cc4);

		for (Conta conta : lista) {
			System.out.println(conta);
		}
		System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");

		//NumeroDaContaComparator comparator = new NumeroDaContaComparator();
		//TitularDaContaComparator titularComparator = new TitularDaContaComparator();
		
		//passando a referencia da classe NumeroDaContaComparator como parametro
		lista.sort(new TitularDaContaComparator());
		
		//Outra maneira de ordenação
		//método esta utilizando o sort, porem nao esta utilizando o comparator comoparametro e sim a ordem natural
		// com o método compareTo direto da classe Conta
		// lista.sort(null);
		
		Collections.sort(lista, new NumeroDaContaComparator());
		
		for (Conta conta : lista) {
			System.out.println(conta + ", Nome: " + conta.getTitular().getNome());
		}
	}
}


//Classe que implementa o Comparator, para ordenar pelo nome do titular da conta
class TitularDaContaComparator implements Comparator<Conta> {

	@Override
	public int compare(Conta c1, Conta c2) {
		String nomeC1 = c1.getTitular().getNome();
		String nomeC2 = c2.getTitular().getNome();

		return nomeC1.compareTo(nomeC2);
	}

}

// Classe que implementa o Comparator, para ordenar pelo numero da conta
class NumeroDaContaComparator implements Comparator<Conta> {

	@Override
	public int compare(Conta c1, Conta c2) {
		
		//Outra maneira de fazer a implementação do metodo compare
		return Integer.compare(c1.getNumero(), c2.getNumero());
		
		//Outra maneira de fazer a implementação do metodo compare
		//return c1.getNumero() - c2.getNumero();

//		Implementação do método compare
//		if (c1.getNumero() < c2.getNumero()) {
//			return -1;
//		}
//
//		if (c1.getNumero() > c2.getNumero()) {
//			return 1;
//		}
//
//		return 0;
	}
}
