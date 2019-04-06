package br.com.bytebank.banco.modelo;
//Array para armazenar objetos do tipo ContaCorrente
//Aula 2

public class TesteArrayReferencias {

	public static void main(String[] args) {

		Object[] referencias = new Object[5];

		ContaCorrente cc1 = new ContaCorrente(22, 11);
		referencias[0] = cc1;

		ContaPoupanca cc2 = new ContaPoupanca(22, 22);
		referencias[1] = cc2;

		Cliente cliente = new Cliente();
	//	referencias[2] =  cliente;

//		System.out.println(contas[1].getNumero());

		ContaPoupanca ref = (ContaPoupanca) referencias[1];
		System.out.println(ref.getNumero());
		System.out.println(cc2.getNumero());
		// for (int i = 0; i < idades.length; i++) {
		// idades[i] = i * i ;
		// }
		//
		// for (int i = 0; i < idades.length; i++) {
		// System.out.println("Valor: "+idades[i]);
		// }
	}

}
