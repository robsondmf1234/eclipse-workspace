package br.com.bytebank.banco.test;

//Ordenando por String 
//Ordenando a lista por ordem natural

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class Test {

	public static void main(String[] args) {
		Conta cc1 = new ContaCorrente(11, 33);
		Cliente clienteCC1 = new Cliente();
		clienteCC1.setNome("Nico");
		cc1.setTitular(clienteCC1);
		cc1.deposita(333.0);

		Conta cc2 = new ContaPoupanca(55, 44);
		Cliente clienteCC2 = new Cliente();
		clienteCC2.setNome("Guilherme");
		cc2.setTitular(clienteCC2);
		cc2.deposita(444.0);

		Conta cc3 = new ContaCorrente(99, 11);
		Cliente clienteCC3 = new Cliente();
		clienteCC3.setNome("Paulo");
		cc3.setTitular(clienteCC3);
		cc3.deposita(111.0);

		Conta cc4 = new ContaPoupanca(66, 22);
		Cliente clienteCC4 = new Cliente();
		clienteCC4.setNome("Ana");
		cc4.setTitular(clienteCC4);
		cc4.deposita(222.0);

		List<Conta> lista = new ArrayList<Conta>();
		lista.add(cc1);
		lista.add(cc2);
		lista.add(cc3);
		lista.add(cc4);

		System.out
				.println(" Organizando por ordem natural.(M�todo compareTo ,foi implementado para ordenar por saldo ");
		Collections.sort(lista);

		for (Conta conta : lista) {
			System.out.println(conta);
		}

		System.out.println("\nMostrando a lista.");
		for (Conta conta : lista) {
			System.out.println(conta);
		}

		System.out.println("\nOrganizado por Numero da Conta");

		// NumeroDaContaComparator compara = new NumeroDaContaComparator();
		lista.sort(new Comparator<Conta>() {

			@Override
			public int compare(Conta c1, Conta c2) {

				// return Integer.compare(c1.getNumero(), c2.getNumero());

				// Outra forma de compara��o
				// return c1.getNumero() - c2.getNumero();

				if (c1.getNumero() < c2.getNumero()) {
					return -1;
				}
				if (c1.getNumero() > c2.getNumero()) {
					return 1;
				}
				return 0;
			}
		});

		for (Conta conta : lista) {
			System.out.println(conta);
		}

		System.out.println("\nOrganizado por agencia");

		// AgenciaDaContaComparator comparaAg = new AgenciaDaContaComparator();
		lista.sort(new Comparator<Conta>() {

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
		});

		for (Conta conta : lista) {
			System.out.println(conta);
		}

		System.out.println("\nOrganizado por Titular");

		// Collections.sort(lista, new TitularDaContaComparator());
		lista.sort(new Comparator<Conta>() {

			@Override
			public int compare(Conta c1, Conta c2) {

				String nomeC1 = c1.getTitular().getNome();
				String nomeC2 = c2.getTitular().getNome();
				return nomeC1.compareTo(nomeC2);
			}

		});

		for (Conta conta : lista) {
			System.out.println(conta + " , " + conta.getTitular().getNome());
		}

	}
}

//// Ordena��o por ordem alfab�tica
// class TitularDaContaComparator implements Comparator<Conta> {
//
// @Override
// public int compare(Conta c1, Conta c2) {
//
// String nomeC1 = c1.getTitular().getNome();
// String nomeC2 = c2.getTitular().getNome();
// return nomeC1.compareTo(nomeC2);
// }
//
// }

// Ordena��o por numero da conta
// class NumeroDaContaComparator implements Comparator<Conta> {
//
// @Override
// public int compare(Conta c1, Conta c2) {
//
// // return Integer.compare(c1.getNumero(), c2.getNumero());
//
// // Outra forma de compara��o
// // return c1.getNumero() - c2.getNumero();
//
// if (c1.getNumero() < c2.getNumero()) {
// return -1;
// }
// if (c1.getNumero() > c2.getNumero()) {
// return 1;
// }
//
// return 0;
// }
// }

// Ordena��o pelo numero da Agencia
// class AgenciaDaContaComparator implements Comparator<Conta> {
//
// @Override
// public int compare(Conta c1, Conta c2) {
//
// if (c1.getAgencia() < c2.getAgencia()) {
// return -1;
// }
// if (c1.getAgencia() > c2.getAgencia()) {
// return 1;
// }
//
// return 0;
// }
//
// }
