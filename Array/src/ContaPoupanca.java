
public class ContaPoupanca extends Conta {

	public ContaPoupanca(int agencia, int numero) {
		// Chamando o construtor especifico
		super(agencia, numero);
	}
	
	//Metodo deposita 
	@Override
	public void deposita(double valor) {
		super.saldo += valor;
	}
}
