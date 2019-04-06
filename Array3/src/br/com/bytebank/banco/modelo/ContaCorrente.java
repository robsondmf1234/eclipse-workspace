package br.com.bytebank.banco.modelo;

public class ContaCorrente extends Object implements Tributavel {

	public ContaCorrente(int agencia, int numero) {
		// Chamando o construtor especifico
		super(agencia, numero);
	}
	
		@Override
	public void saca(double valor) {
		double valorASacar = valor + 0.2;
		// chamado o metodo saca da classe Mae
		super.saca(valorASacar);
	}

	@Override
	public void deposita(double valor) {
		super.saldo += valor;
	}

	@Override
	public double getValorImposto() {
		return super.saldo * 0.01;
	}
}
