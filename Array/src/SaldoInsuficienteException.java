//Classe criada para gerar erro referente a saldo insuficiente
public class SaldoInsuficienteException extends RuntimeException {
	
	public SaldoInsuficienteException(String msg) {
		super(msg);
	}

}
