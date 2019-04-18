//Clase Conta Corrente
public class ContaCorrente extends Conta implements Tributavel {
	
	//Construtor
	public ContaCorrente(int agencia, int numero) {
		// Chamando o construtor especifico
		super(agencia, numero);
	}
	
	//Metodo sobrescrito, será ascredio 20% ao valor ao saque
	@Override
	public void saca(double valor) {
		double valorASacar = valor + 0.2;
		// chamado o metodo saca da classe Mae
		super.saca(valorASacar);
	}
	
	//Metodo deposita
	@Override
	public void deposita(double valor) {
		super.saldo += valor;
	}
	
	//Metodo que recupera o valor do imposto
	@Override
	public double getValorImposto() {
		return super.saldo * 0.01;
	}
}
