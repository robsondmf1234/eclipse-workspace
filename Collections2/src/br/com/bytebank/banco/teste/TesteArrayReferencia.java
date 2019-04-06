package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

//Array [] 
public class TesteArrayReferencia {

	public static void main(String[] args) {

//		Conta[] contas = new Conta[5];
		
		//Array mais genérico
		Object[] referencias = new Object[5];
		
		ContaCorrente cc1 = new ContaCorrente(111, 222);
		ContaPoupanca cc2 = new ContaPoupanca(111, 333);

		referencias[0] = cc1;
		referencias[1] = cc2;

		Cliente cliente = new Cliente();
		referencias[2] = cliente;
		
		//System.out.println(referencias[0].getNumero());

		ContaPoupanca ref = (ContaPoupanca) referencias[1];

		System.out.println(cc2.getNumero());
		System.out.println(cc1.getNumero());

	}

}
