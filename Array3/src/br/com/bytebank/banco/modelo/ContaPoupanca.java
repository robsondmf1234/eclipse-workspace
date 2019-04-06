package br.com.bytebank.banco.modelo;

public class ContaPoupanca extends Object {

	public ContaPoupanca(int agencia, int numero) {
		// Chamando o construtor especifico
		super(agencia, numero);
	}

	@Override
	public void deposita(double valor) {
		super.saldo += valor;
	}
}
