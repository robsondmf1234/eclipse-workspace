package br.com.bytebank.banco.modelo;

public class TesteSaca {

	public static void main(String[] args) {

		Object conta = new ContaCorrente(123, 321);

		conta.deposita(200);
		conta.saca(195);

		System.out.println(conta.getSaldo());
	}

}
