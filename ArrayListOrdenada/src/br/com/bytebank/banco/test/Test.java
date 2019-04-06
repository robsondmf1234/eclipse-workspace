package br.com.bytebank.banco.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class Test {

	public static void main(String[] args) {

		Conta cc1 = new ContaCorrente(77, 55);
		cc1.deposita(333.0);
		Conta cc2 = new ContaPoupanca(44, 33);
		cc2.deposita(444.0);
		Conta cc3 = new ContaCorrente(55, 11);
		cc3.deposita(111.0);
		Conta cc4 = new ContaPoupanca(11, 22);
		cc4.deposita(222.0);

		List<Conta> lista = new ArrayList<Conta>();
		lista.add(cc1);
		lista.add(cc2);
		lista.add(cc3);
		lista.add(cc4);

		for (Conta conta : lista) {
			System.out.println(conta);
		}
		
		System.out.println(" Organizado por conta");

		NumeroDaContaComparator compara = new NumeroDaContaComparator();
		lista.sort(compara);
		
		for (Conta conta : lista) {
			System.out.println(conta);
		}
		System.out.println(" Organizado por agencia");
		
//		AgenciaDaContaComparator comparaAg = new AgenciaDaContaComparator();
		lista.sort(new AgenciaDaContaComparator());
		
		for (Conta conta : lista) {
			System.out.println(conta);
		}
	}
}

class NumeroDaContaComparator implements Comparator<Conta> {

	@Override
	public int compare(Conta c1, Conta c2) {
		
//		return Integer.compare(c1.getNumero(), c2.getNumero());
		
//		Outra forma de comparação
//		return c1.getNumero() - c2.getNumero();
		
		if (c1.getNumero() < c2.getNumero()) {
			return -1;
		}
		if (c1.getNumero() > c2.getNumero()) {
			return 1;
		}

		return 0;
	}
}

class AgenciaDaContaComparator implements Comparator<Conta>{

	@Override
	public int compare(Conta c1, Conta c2) {

		if (c1.getAgencia() < c2.getAgencia()) {
			return -1;
		}
		if (c1.getAgencia() > c2.getAgencia()) {
			return 1;
		}
		
		return 0;
	}
	
}
