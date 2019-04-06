//Aula 5.6

public class TesteSaca {

	public static void main(String[] args) {

		Conta conta = new ContaCorrente(123, 321);

		try {
			conta.deposita(200);
			conta.saca(195);
		} catch (SaldoInsuficienteException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(conta.getSaldo());
	}

}
