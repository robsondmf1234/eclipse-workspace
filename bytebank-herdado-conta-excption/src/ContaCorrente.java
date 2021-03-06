
public class ContaCorrente extends Conta implements Tributavel {

	public ContaCorrente(int agencia, int numero) {
		// Chamando o construtor especifico
		super(agencia, numero);
	}

	@Override
	public void saca(double valor) throws SaldoInsuficienteExcption{
		double valorASacar = valor + 0.2;
		// chamado o metodo saca da classe Mae
		System.out.println("Valor de saque realizado: "+valor);
		super.saca(valorASacar);
		System.out.println("Saldo: "+super.getSaldo());
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
