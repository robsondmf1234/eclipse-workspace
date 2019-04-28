//Classe Para testar as contas
public class TesteContas {

	public static void main(String[] args) {
		
		//Instanciando um objeto do tipo ContaCorrente
		ContaCorrente cc = new ContaCorrente(1337, 23334);
		//Chamado o método deposita
		cc.deposita(100.0);
	
		//Instanciando um objeto do tipo ContaPoupanca
		ContaPoupanca cp = new ContaPoupanca(222, 222);
		//Chamado o método deposita
		cp.deposita(200);
		
		//Transferindo dinheiro para conta poupanca
		cc.transfere(10.0, cp);

		System.out.println("Conta corrente: " + cc.getSaldo());
		System.out.println("Conta poupança: " + cp.getSaldo());

	
	}

}
