//Aula 6.1
public class TestaContaComExcecaoChecked {

	public static void main(String[] args) {

		
		Conta c = new Conta();
		
		try {
			c.deposita();
		} catch (Minhaexcecao e) {
		System.out.println("Tratamento...");
		}
	}

}
