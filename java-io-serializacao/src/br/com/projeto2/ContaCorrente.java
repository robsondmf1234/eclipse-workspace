package br.com.projeto2;

import java.io.Serializable;

public class ContaCorrente extends Conta implements Tributavel,Serializable {

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
