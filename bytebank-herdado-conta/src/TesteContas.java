public class TesteContas {

	public static void main(String[] args) {

		ContaCorrente cc = new ContaCorrente(1337, 23334);
		cc.deposita(100.0);

		ContaPoupanca cp = new ContaPoupanca(222, 222);
		cp.deposita(200);

		cc.transfere(10.0, cp);

		System.out.println("Conta corrente: " + cc.getSaldo());
		System.out.println("Conta poupança: " + cp.getSaldo());

		// System.out.println("o total de contas é : " + Conta.getTotal());
		// System.out.println(conta.getSaldo());
		// Conta.setAgencia(570);
		// System.out.println(conta.getAgencia());

	}

}
